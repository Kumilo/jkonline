package com.hemax.jkt.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

import com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect;
import com.hemax.jkt.web.dialect.ThymeleafExtendDialect;

/**
 * @author hongzheng.liu
 */
@Configuration
@ConditionalOnWebApplication
public class ThymeleafConfig {
	private static final Logger log = LoggerFactory.getLogger(ThymeleafConfig.class);

	@Configuration
	@ConditionalOnClass(name = "org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect")
	protected static class ThymeleafConditionalCommentsDialectConfiguration {
		@Bean
		public ConditionalCommentsDialect conditionalCommentsDialect() {
			return new ConditionalCommentsDialect();
		}
	}

	@Configuration
	@ConditionalOnClass(name = "com.github.mxab.thymeleaf.extras.dataattribute.dialect.DataAttributeDialect")
	protected static class ThymeleafDataAttributeConfiguration {
		@Bean
		public DataAttributeDialect dataAttributeDialect() {
			return new DataAttributeDialect();
		}
	}

    @Configuration
    @ConditionalOnClass(name = "at.pollux.thymeleaf.shiro.dialect.ShiroDialect")
    protected static class ThymeleafShiroDialectConfiguration {
        @Bean
        public ShiroDialect shiroDialect() {
            return new ShiroDialect();
        }
    }

	@Bean
	public ThymeleafExtendDialect extendDialect() {
		return new ThymeleafExtendDialect();
	}

	@Configuration
	@ConditionalOnClass(TemplateEngine.class)
	protected static class AjaxThymeleafMvcInterceptorConfiguration extends WebMvcConfigurerAdapter {
		private static final String AJAX_REQUEST_PARAM = "x-requested-with";
		private static final String AJAX_REQUEST_VALUE = "XMLHttpRequest";

		@Autowired
		private ThymeleafProperties properties;

		@Autowired
		private final ResourceLoader resourceLoader = new DefaultResourceLoader();

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new HandlerInterceptorAdapter() {
				@Override
				public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
						throws Exception {
					if (null != modelAndView) {
						String view = modelAndView.getViewName(), ajaxRequest = request.getHeader(AJAX_REQUEST_PARAM);
						if (null != view && AJAX_REQUEST_VALUE.equalsIgnoreCase(ajaxRequest)) {
							int last = view.lastIndexOf('/');
							String ajaxView = last > 0 ? view.substring(0, last) + "/_" + view.substring(last + 1) : "_" + view;

							if (resourceLoader.getResource(properties.getPrefix() + ajaxView + properties.getSuffix()).exists()) {
								modelAndView.setViewName(ajaxView);
							}
						}
					} else {
						log.debug("!!! Null modelAndView on url: {}", request.getRequestURI());
					}
				}
			});
		}
	}
}
