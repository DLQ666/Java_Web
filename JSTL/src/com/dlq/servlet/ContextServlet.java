package com.dlq.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-16 11:50
 */
public class ContextServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        // 1. getRealPath()  获取资源文件的真实路径： String path
        // String path = this.getServletContext().getRealPath("/file/a.jpg");
        // FileInputStream in = new FileInputStream(new File(path));

        // 3. getResource() 获得资源文件的URL 与第一种相似
        URL url = getServletContext().getResource("/file/a.jpg");
        // 2. getResourceAsStream() 直接获得资源文件的输入流； InputStream
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/file/");
        ServletOutputStream outputStream = resp.getOutputStream();

    }
}
