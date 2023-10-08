package com.example.springboot_02.service.impl;

import com.example.springboot_02.mapper.UserMapper;
import com.example.springboot_02.pojo.User;
import com.example.springboot_02.service.UserService;
import com.example.springboot_02.utils.SaltUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * className:UserServiceImpl
 * Package:com.example.springboot_02.service.impl
 * Description: TODO
 *
 * @Date: 2023/10/7 10:22
 * @Author:hjy
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void register(User user) {
        String salt = SaltUtils.getSalt(8);
        user.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());
        userMapper.register(user);
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }
}
