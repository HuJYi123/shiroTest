package com.example.springboot_02.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * className:User
 * Package:com.example.springboot_02.pojo
 * Description: TODO
 *
 * @Date: 2023/10/7 10:28
 * @Author:hjy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private String password;
    private String salt;
}
