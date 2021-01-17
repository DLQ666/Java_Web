package com.dlq.cookie;

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
        response.setContentType("text/html; charset=UTF-8");
        String acton = request.getParameter("action");
//        System.out.println(acton);

        Method method = null;
        try {
            method = this.getClass().getDeclaredMethod(acton,
                    HttpServletRequest.class,
                    HttpServletResponse.class);
            method.invoke(this,request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
