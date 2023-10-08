package com.example.springboot_02.controller;

import com.example.springboot_02.pojo.User;
import com.example.springboot_02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * className:UserController
 * Package:com.example.springboot_02.controller
 * Description: TODO
 *
 * @Date: 2023/10/8 10:58
 * @Author:hjy
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public void register(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userService.register(user);
    }
}
