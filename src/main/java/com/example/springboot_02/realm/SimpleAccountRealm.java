package com.example.springboot_02.realm;

import com.example.springboot_02.pojo.Role;
import com.example.springboot_02.pojo.User;
import com.example.springboot_02.service.RoleService;
import com.example.springboot_02.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;

/**
 * className:SimpleAccountRealm
 * Package:com.example.springboot_02.realm
 * Description: TODO
 *
 * @Date: 2023/10/7 17:35
 * @Author:hjy
 */
public class SimpleAccountRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    /**
     * 用户的授权：权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println("as:" + primaryPrincipal);
        User user = userService.findByName(primaryPrincipal);
        List<Role> list = roleService.getRolesByUserId(user.getId());
        if (!CollectionUtils.isEmpty(list)) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            list.forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    /**
     * 登录用户的认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        System.out.println(principal);
        User user = userService.findByName(principal);
        if (!ObjectUtils.isEmpty(user)) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
