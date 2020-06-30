package com.aifyun.aiyun.configuration;

import com.aifyun.aiyun.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

/**
 * web设置
 * @author LiuchangLan
 * @date 2020/6/30 10:18
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Value("${auth.Login.NotInterception}")
    private String notInterceptor;

    /**
     * @description 登录请求拦截器
     * @author LiuChangLan
     * @since 2020/6/30 11:34
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor()).excludePathPatterns(Arrays.asList(notInterceptor.split(",")));
    }
}
