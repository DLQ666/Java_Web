package com.dlq.servlet;

import com.dlq.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void testPath(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cookie cookie = new Cookie("path1", "path1");
        // getcontextPath( ) ===>>>> 得到工程路径
        cookie.setPath(request.getContextPath() + "/abc"); //===>>>> /工程路径/abc
        response.addCookie(cookie);

        response.getWriter().write("创建了一个带有path路径的Cookie");
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);

        response.getWriter().write("key2的Cookie值已修改好");
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cookie cookie = CookieUtils.findCookie("key1", request.getCookies());
        if (cookie != null){
            cookie.setMaxAge(0);
            response.addCookie(cookie);

            response.getWriter().write("key1的Cookie值已被删除");
        }
    }

    protected void life60(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cookie cookie = new Cookie("life60", "life60");
        cookie.setMaxAge(60);
        response.addCookie(cookie);

        response.getWriter().write("已经创建了一个存活60秒的Cookie");
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //方案一：
        //1、先创建一个要修改的同名（指的就是key）的Cookie对象
        //2、在构造器，同时赋于新的Cookie值。
        //Cookie cookie = new Cookie("key1","newValue1");
        //3、调用response.addCookie(Cookie);
        //response.addCookie(cookie);

        //response.getWriter().write("key1的Cookie值已修改好");

        //方案二：
        //1、先查找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key2", request.getCookies());
        if (cookie != null) {
            //2、调用setValue()方法赋于新的Cookie值。
            cookie.setValue("newValue2");
            //3、调用response.addCookie()通知客户端保存修改
            response.addCookie(cookie);
        }

        response.getWriter().write("key2的Cookie值已修改好");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //getName方法返回cookie的key (名称)
            //getvalue方法返回cookie的value值
            response.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }

        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);
        //如果不等于null，说明赋过值，也就是找到了需要的Cookie
        if (iWantCookie!=null){
            response.getWriter().write("找到了需要的Cookie");
        }
    }

    protected void createCookie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //1、创建cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2、通知客户端保存cookie
        response.addCookie(cookie);

        Cookie cookie1 = new Cookie("key2", "value2");
        response.addCookie(cookie1);

        response.getWriter().write("Cookie创建成功！");
    }

}
