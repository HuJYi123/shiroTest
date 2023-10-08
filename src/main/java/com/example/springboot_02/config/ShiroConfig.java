package com.example.springboot_02.config;

import com.example.springboot_02.realm.SimpleAccountRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * className:ShiroConfig
 * Package:com.example.springboot_02.config
 * Description: TODO
 *
 * @Date: 2023/10/7 18:13
 * @Author:hjy
 */
@Configuration
public class ShiroConfig {
    /**
     * 负责拦截所有请求
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        return filterFactoryBean;
    }

    /**
     * 创建安全管理器，需使用web环境下的
     * @param realm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager getDefaultSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(realm);
        return defaultSecurityManager;
    }

    @Bean
    public Realm getRealm() {
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        //设置realm使用Hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);
        simpleAccountRealm.setCredentialsMatcher(credentialsMatcher);
        return simpleAccountRealm;
    }
}
