package com.dlq.servlet;

import com.dlq.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-19 19:58
 */
public class AjaxServlet extends BaseServlet{

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("Ajax请求过来了！！");
        Person person = new Person(1,"李四");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("jQueryAjax == 方法调用了！！");

        Person person = new Person(1,"李四");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("jQueryGet == 方法调用了！！");

        Person person = new Person(1,"李四");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("jQueryPost == 方法调用了！！");

        Person person = new Person(1,"李四");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGetJson(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("jQueryGetJson == 方法调用了！！");

        Person person = new Person(1,"李四");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        System.out.println("jQuerySerialize == 方法调用了！！");

        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));

        Person person = new Person(1,"李四");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
}
