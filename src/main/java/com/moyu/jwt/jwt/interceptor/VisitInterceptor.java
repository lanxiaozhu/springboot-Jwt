package com.moyu.jwt.jwt.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class VisitInterceptor implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        String[] patterns = new String[]{"login","/*.html"};
        registry.addInterceptor(new SysInterceptor())//拦截器、
                .addPathPatterns("/**")//拦截所有访问路径
                .excludePathPatterns(patterns);
    }
}
