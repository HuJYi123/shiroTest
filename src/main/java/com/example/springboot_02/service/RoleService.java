package com.example.springboot_02.service;

import com.example.springboot_02.pojo.Role;

import java.util.List;

/**
 * className:RoleService
 * Package:com.example.springboot_02.service
 * Description: TODO
 *
 * @Date: 2023/10/18 11:34
 * @Author:hjy
 */
public interface RoleService {
    List<Role> getRolesByUserId(Integer userId);
}
