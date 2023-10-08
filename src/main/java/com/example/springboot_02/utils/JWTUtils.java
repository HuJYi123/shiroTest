package com.example.springboot_02.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Base64;
import java.util.Calendar;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * className:JWTUtils
 * Package:com.example.springboot_02.utils
 * Description: TODO
 *
 * @Date: 2023/10/7 10:00
 * @Author:hjy
 */
public class JWTUtils {
    public static final String TOKEN = "Addsf!#$^%@Y&^*&$@sf4323";
    /**
     * 生成token
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k,v);
        });
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 30);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(TOKEN)).toString();
    }

    /**
     * 验证token，验证通过则返回payload，失败则抛出异常
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(TOKEN)).build().verify(token);
    }
}
