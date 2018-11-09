package com.moyu.jwt.jwt.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * 浏览器的非简单请求
     * 自动发出一个"预检"请求 OPTIONS
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")///**代表所有路径
                .allowedOrigins("*")//允许源 就是协议、域名和端口号。例如：http://www.baidu.com:80这个URL
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE","OPTIONS")//允许访问的请求方式
                .allowCredentials(false).maxAge(3600);
        //Credentials  是否允许用户发送、处理 cookie
        //maxAge 预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
    }
}
