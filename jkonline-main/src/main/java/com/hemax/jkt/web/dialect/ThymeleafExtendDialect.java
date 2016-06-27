package com.hemax.jkt.web.dialect;

import java.util.Map;

import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.spring4.dialect.SpringStandardDialect;

import com.hemax.jkt.web.expression.Cookie;
import com.hemax.jkt.web.expression.PageUrl;

public class ThymeleafExtendDialect extends SpringStandardDialect {
    public static final String COOKIES_EXPRESSION_OBJECT_NAME = "cookie";
    public static final String PAGES_EXPRESSION_OBJECT_NAME = "pageurl";

    @Override
    public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {
        final Map<String, Object> additionalExpressionObjects = super.getAdditionalExpressionObjects(processingContext);
        additionalExpressionObjects.put(COOKIES_EXPRESSION_OBJECT_NAME, new Cookie(processingContext));
        additionalExpressionObjects.put(PAGES_EXPRESSION_OBJECT_NAME, new PageUrl(processingContext));
        return additionalExpressionObjects;
    }
}
