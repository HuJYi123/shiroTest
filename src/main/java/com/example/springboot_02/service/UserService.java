package com.example.springboot_02.service;

import com.example.springboot_02.pojo.User;

/**
 * className:UserService
 * Package:com.example.springboot_02.service
 * Description: TODO
 *
 * @Date: 2023/10/7 10:22
 * @Author:hjy
 */
public interface UserService {
    User login(User user);

    void register(User user);

    User findByName(String name);
}
