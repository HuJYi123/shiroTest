package com.example.springboot_02.utils;

import java.util.Random;

/**
 * className:SaltUtils
 * Package:com.example.springboot_02.utils
 * Description: TODO
 *
 * @Date: 2023/10/8 10:37
 * @Author:hjy
 */
public class SaltUtils {
    public static String getSalt(int n) {
        char[] chars = "asfdasfhASFAFASF@$#@%@^%14312432".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
