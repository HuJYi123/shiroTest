package com.example.springboot_02;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springboot_02.realm.SimpleAccountRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Calendar;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringBoot02ApplicationTests {

    @Test
    public void test1() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 30);
        String sign = JWT.create()
                .withClaim("userid", 12)
                .withClaim("username", "zhangsan")
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("adad435!#@$"));
        System.out.println(sign);
    }

    @Test
    public void test2() {
        JWTVerifier build = JWT.require(Algorithm.HMAC256("adad435!#@$")).build();
        DecodedJWT verify = build.verify(
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyIiOiJ6aGFuZ3NhbiIsImV4cCI6MTY5NjY0Mzg5NywidXNlcmlkIjoxMn0.KSxot4uLcidaGi46_5lCO6EJxkRoXmepk1-12p1HTPI");
        System.out.println(verify.getClaim("userid").asInt());
        System.out.println(verify.getClaim("username").asString());
    }

    @Test
    public void test3() {
        //创建安全管理器对象
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        SimpleAccountRealm realm = new SimpleAccountRealm();
        //设置realm使用Hash凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        //给安全管理器设置realm
        defaultSecurityManager.setRealm(realm);
        //给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //关键对象subject主体
        Subject subject = SecurityUtils.getSubject();
        //创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        //用户认证
        try {
            subject.login(token);
        }catch (Exception e) {
            e.printStackTrace();
        }
        if (subject.hasRole("admin")) {
            System.out.println("有admin角色");
        }
        if (subject.isAuthenticated()) {
            System.out.println(subject.hasRole("admin"));
        }
    }

    @Test
    public void test4() {
        Md5Hash md5Hash = new Md5Hash("123456", "afaf!#@!", 1024);
        System.out.println(md5Hash.toHex());
    }
}
