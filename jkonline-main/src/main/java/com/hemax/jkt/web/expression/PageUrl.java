package com.hemax.jkt.web.expression;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.spring4.context.SpringWebContext;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class PageUrl {
    private HttpServletRequest request;

    public PageUrl(final IProcessingContext processingContext) {
        SpringWebContext context = (SpringWebContext) processingContext.getContext();
        this.request = context.getHttpServletRequest();
    }

    public String get() {
        if (this.request == null) {
            throw new TemplateProcessingException("Pages cannot be resolved because RequestContext was not found. "
                    + "Are you using a Context object without a SpringWebContext variable?");
        }

        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            String val = entry.getValue()[0];
            if (StringUtils.isNotBlank(val)) {
                try {
                    params.put(entry.getKey(), URLEncoder.encode(val, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    // do nothing
                }
            }
        }
        params.remove("page");
        params.remove("Csrf");

        StringBuilder sb = new StringBuilder();
        sb.append(request.getServletPath());
        if (!params.isEmpty()) {
            sb.append("?").append(Joiner.on("&").withKeyValueSeparator("=").join(params));
        }

        return sb.toString();
    }
}
