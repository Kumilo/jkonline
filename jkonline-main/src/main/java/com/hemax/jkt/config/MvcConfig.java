/**
 * MSXF
 */
package com.hemax.jkt.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ConditionalOnWebApplication
public class MvcConfig extends WebMvcConfigurerAdapter implements MessageSourceAware {

    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

//    @Bean
//    public FilterRegistrationBean etagFilterConfig() {
//        FilterRegistrationBean reg = new FilterRegistrationBean();
//        reg.setName("EtagFilter");
//        reg.setFilter(new ShallowEtagHeaderFilter());
//        reg.addUrlPatterns("/static/*");
//        return reg;
//    }
   
    
//    @Bean
//    public HttpMessageConverters stringHttpMessageConverter(){
//    	StringHttpMessageConverter fastConverter = new StringHttpMessageConverter();//2
//        return new HttpMessageConverters(fastConverter);
//    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jkstatic/**").addResourceLocations("classpath:/jkstatic/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    /**
     * Replaced by {@link com.msxf.msapi.main.aspect.ApiAspect} <br>
     * use {@link com.msxf.eyas.common.util.ValidatorUtil}
     */
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setProviderClass(HibernateValidator.class);
        factory.setValidationMessageSource(this.messageSource);
        return factory;
    }
 
    
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new RateLimitInterceptor()).addPathPatterns("/*");
//		super.addInterceptors(registry);
//	}
}
