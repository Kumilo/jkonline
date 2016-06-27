package com.hemax.jkt.web.expression;

import org.springframework.web.util.WebUtils;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.spring4.context.SpringWebContext;

import javax.servlet.http.HttpServletRequest;

public class Cookie {
	private HttpServletRequest request;

	public Cookie(final IProcessingContext processingContext) {
		final SpringWebContext context = (SpringWebContext) processingContext.getContext();
		this.request = context.getHttpServletRequest();
	}

	public String get(final String cookieName) {
		if (this.request == null) {
			throw new TemplateProcessingException("Cookie cannot be resolved because RequestContext was not found. "
					+ "Are you using a Context object without a SpringWebContext variable?");
		}
		javax.servlet.http.Cookie cookie = WebUtils.getCookie(request, cookieName);

		return cookie == null ? null : cookie.getValue();
	}

}
