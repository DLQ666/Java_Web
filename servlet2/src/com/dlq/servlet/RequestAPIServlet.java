package com.dlq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-13 17:11
 */
public class RequestAPIServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        //getRequestURI() 获取请求的资源路径
        System.out.println("获取请求的资源路径URI：=>" + req.getRequestURI());
        //getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("获取请求的统一资源定位符URL：=>" + req.getRequestURL());
        /*
          在IDEA中，使用localhost访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1
          在IDEA中，使用127.0.0.1访问时，得到的客户端 ip 地址是 ===>>> 127.0.0.1
          在IDEA中，使用 真实 ip 访问时，得到的客户端 ip 地址是 ===>>> 真实的客户端 ip 地址
         */
        //getRemoteHost() 获取客户端的 ip 地址
        System.out.println("获取客户端的 ip 地址：=>" + req.getRemoteHost());
        //getHeader() 获取请求头
        String header = req.getHeader("User-Agent");
        System.out.println("获取请求头User-Agent：=>" + header);
        //getMethod() 获取请求的方式 GET 或 POST
        System.out.println("获取请求的方式：=>"+req.getMethod());
    }

}
