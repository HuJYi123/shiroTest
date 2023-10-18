package com.example.springboot_02.controller;

import com.example.springboot_02.pojo.User;
import com.example.springboot_02.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            // 登录认证
            subject.login(token);
            return "login success";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            throw new RuntimeException("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            throw new RuntimeException("密码错误");
        }
    }
}
