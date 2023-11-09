package com.example.springboot_02.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.springboot_02.pojo.User;
import com.example.springboot_02.service.UserService;
import com.example.springboot_02.utils.JWTUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * className:JWTController
 * Package:com.example.springboot_02.controller
 * Description: TODO
 *
 * @Date: 2023/10/7 9:46
 * @Author:hjy
 */
@RestController
@RequestMapping("/test")
public class JWTController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            User u = userService.login(user);
            Map<String, String> payload = new HashMap<>();
            payload.put("id", u.getId().toString());
            payload.put("name", u.getName());
            String token = JWTUtils.getToken(payload);
            map.put("status", true);
            map.put("mag", "认证成功");
            map.put("token", token);
        } catch (Exception e) {
            map.put("status", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }
}
