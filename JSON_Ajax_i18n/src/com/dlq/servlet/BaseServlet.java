package com.dlq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-16 15:30
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        //解决post请求中文乱码问题
        //一定要在获取请求参数之前调用才有效
        response.setContentType("text/html; charset=UTF-8");

        String acton = request.getParameter("action");
//        System.out.println(acton);

        Method method = null;
        try {
            //获取action业务鉴别字符串，获取相应的业务方法反射对象
            method = this.getClass().getDeclaredMethod(acton,
                    HttpServletRequest.class,
                    HttpServletResponse.class);
            //调用目标业务 方法
            method.invoke(this,request,response);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e); //把异常抛给Filter过滤器
        }
    }
}
