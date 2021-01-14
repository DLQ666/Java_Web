package com.dlq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-13 19:16
 */
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("--------------doGet--------------");
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("用户名：" + username);
        String password = req.getParameter("password");
        System.out.println("密码：" + password);
        //getParameterValues() 获取请求的参数（多个值的时候使用）
        String[] hobby = req.getParameterValues("hobby");
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String password = req.getParameter("password");
        // 设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
        // 也要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        System.out.println("--------------doPost--------------");
        //获取请求的参数
        String username = req.getParameter("username");
        System.out.println("用户名：" + username);
        System.out.println("密码：" + password);
        //getParameterValues() 获取请求的参数（多个值的时候使用）
        String[] hobby = req.getParameterValues("hobby");
        System.out.println("兴趣爱好：" + Arrays.asList(hobby));
    }
}
