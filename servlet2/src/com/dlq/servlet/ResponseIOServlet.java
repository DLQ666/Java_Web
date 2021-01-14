package com.dlq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-14 12:30
 */
public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        //System.out.println(resp.getCharacterEncoding()); //ISO-8859-1

        //它会同时设置服务器与客户端都使用UTF-8字符集，还设置了响应头
        //此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html; charset=UTF-8");
        System.out.println(resp.getCharacterEncoding());

        //要求：往客户端回传字符串数据。
        PrintWriter writer = resp.getWriter();
        //writer.println();
        writer.write("哈哈哈哈哈哈哈哈哈!!!");
    }
}
