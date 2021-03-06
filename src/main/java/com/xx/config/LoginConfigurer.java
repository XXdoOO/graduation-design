package com.xx.config;

import com.xx.filter.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public interface LoginConfigurer extends WebMvcConfigurer {
    @Override
    default void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(new LoginFilter());
        interceptor.addPathPatterns("/pushBlog", "/removeBlog", "/updateBlog", "/myBlog", "/myStar", "/star", "/pushComments")
                .excludePathPatterns("/login", "/register", "/getAllBlog", "/getBlogByKeywords", "/getBlogByUsername");
    }
}
