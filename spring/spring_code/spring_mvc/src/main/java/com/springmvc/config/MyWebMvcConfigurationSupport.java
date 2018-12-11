package com.springmvc.config;

import com.springmvc.web.DataMessageConvert;
import com.springmvc.web.MyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.*;

public class MyWebMvcConfigurationSupport extends WebMvcConfigurationSupport {
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = super.requestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new DataMessageConvert());
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<HandlerMethodArgumentResolver>();
        argumentResolvers.add(new MyResolver(converters));
        requestMappingHandlerAdapter.setCustomArgumentResolvers(argumentResolvers);
        List<HandlerMethodReturnValueHandler> returnValueHandlers = new ArrayList<HandlerMethodReturnValueHandler>();
        returnValueHandlers.add(new MyResolver(converters));
        requestMappingHandlerAdapter.setCustomReturnValueHandlers(returnValueHandlers);
        return requestMappingHandlerAdapter;
    }
}
