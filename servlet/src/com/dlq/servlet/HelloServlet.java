package com.dlq.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-12 20:25
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1--->  执行构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2--->  执行init初始化方法");
        //1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是："+servletConfig.getServletName());
        //2、获取初始化参数init-param
        System.out.println();
        System.out.println("初始化参数username的值是"+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是"+servletConfig.getInitParameter("url"));
        //3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException {
        System.out.println("3---->  执行service方法 == Hello Servlet!!! " +
                "Tomcat的"+servletRequest.getClass()+"类实现了ServletRequest子接口HttpServletRequest");
        //类型转换(因为它有getMethod()方法)
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求的方式
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method)){
            doGet();
        }else if("POST".equals(method)){
            doPost();
        }
    }

    /**
     * 做get请求操作
     */
    public void doGet(){
        System.out.println("get---请求");
        System.out.println("get---请求aaaa");
        System.out.println("get---请求aaaaaa");
    }

    /**
     * 做post请求操作
     */
    public void doPost(){
        System.out.println("post---请求");
        System.out.println("post---请求aa");
        System.out.println("post---请求aaaa");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4--->  执行destroy销毁方法");
    }
}
