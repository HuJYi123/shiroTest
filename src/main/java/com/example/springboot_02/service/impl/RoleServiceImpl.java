package com.example.springboot_02.service.impl;

import com.example.springboot_02.mapper.RoleMapper;
import com.example.springboot_02.pojo.Role;
import com.example.springboot_02.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * className:RoleServiceImpl
 * Package:com.example.springboot_02.service.impl
 * Description: TODO
 *
 * @Date: 2023/10/18 11:34
 * @Author:hjy
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> getRolesByUserId(Integer userId) {
        return roleMapper.getRolesByUserId(userId);
    }
}
