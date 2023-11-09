package com.example.springboot_02.config;

import com.example.springboot_02.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * className:SpringMVCConfig
 * Package:com.example.springboot_02.config
 * Description: TODO
 *
 * @Date: 2023/10/18 14:40
 * @Author:hjy
 */
@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/**");
    }
}
