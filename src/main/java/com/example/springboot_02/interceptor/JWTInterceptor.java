package com.example.springboot_02.interceptor;

import com.example.springboot_02.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * className:JWTInterceptor
 * Package:com.example.springboot_02.interceptor
 * Description: TODO
 *
 * @Date: 2023/10/18 14:36
 * @Author:hjy
 */
@Component
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头中的令牌
        String token = request.getHeader("token");
        //验证令牌
        try {
            JWTUtils.verify(token);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("令牌无效");
        }
    }
}
