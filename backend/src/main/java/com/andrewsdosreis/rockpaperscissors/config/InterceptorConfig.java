package com.andrewsdosreis.rockpaperscissors.config;

import com.andrewsdosreis.rockpaperscissors.interceptor.RequestInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private RequestInterceptor interceptor;

    public InterceptorConfig(RequestInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/v1/rounds");
    }
}
