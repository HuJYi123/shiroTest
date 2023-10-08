package com.example.springboot_02;

import com.example.springboot_02.pojo.User;
import com.example.springboot_02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * className:Test
 * Package:com.example.springboot_02
 * Description: TODO
 *
 * @Date: 2023/10/8 10:49
 * @Author:hjy
 */
@SpringBootTest()
public class Test {
    @Autowired
    private UserService userService;
   @org.junit.jupiter.api.Test
    public void test1() {
       User user = new User();
       user.setName("wangwu");
       user.setPassword("123456");
       userService.register(user);
   }
}
