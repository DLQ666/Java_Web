package com.dlq.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //获取ServletContext对象
        ServletContext context = getServletContext();
        System.out.println(context);

        System.out.println("Context2222 中获取域数据key1 的值是："+context.getAttribute("key1"));
    }
}
