package com.dlq.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-13 10:21
 */
public class HelloServlet2 extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("重写了init初始化方法，做了一些工作！！！");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("HelloServlet2 的doGet方法");
        ServletConfig config = getServletConfig();
        //1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是："+config.getServletName());
        //2、获取初始化参数init-param
        System.out.println("初始化参数username的值是"+config.getInitParameter("username"));
        System.out.println("初始化参数url的值是"+config.getInitParameter("url"));
        //3、获取ServletContext对象
        System.out.println(config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("HelloServlet2 的doPost方法");
    }
}
