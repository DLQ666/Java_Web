package com.dlq.utils;

import javax.servlet.http.Cookie;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-17 18:35
 */
public class CookieUtils {

    /**
     * 查找指定名称的Cookie对象
     * @param name 指定名称
     * @param cookies 传入的Cookie数组
     * @return Cookie对象
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if (name == null || cookies == null || cookies.length==0){
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }
}
