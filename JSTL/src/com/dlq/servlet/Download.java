package com.dlq.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class Download extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //1、获取要下或的文件名
        String downloadFileName = "a.jpg";
        //2、读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();
        //4，在回传前，通过响应头告诉客户端返回的数据类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println(mimeType);
        response.setContentType(mimeType);
        //5，还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        // Content-Disposition响应头，表示收到的数据怎么处理
        // attachment 表示附件，表示下载使用
        // fileName= 表示指定下载的文件名
        String ua=request.getHeader("User-Agent");
        if (ua.contains("Firefox")) {
            //如果是火狐浏览器使用Base64编码
            response.setHeader("Content-Disposition", "attachment; fileName=" + "=?utf-8?B?" +
                    new BASE64Encoder().encode("中文.jpg".getBytes("utf-8")) + "?=");
        } else {
            //如果不是火狐，是IE或谷歌，使用URL编码操作
            response.setHeader("Content-Disposition", "attachment; fileName=" +
                    URLEncoder.encode("中国.jpg", "UTF-8"));
        }
        //读取要下载的文件内容
        InputStream inputStream = servletContext.getResourceAsStream("/file/"+downloadFileName);
        //3、把下载的文件内容回传给客户端
        //获取响应的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
    }
}
