package com.dlq.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-13 20:27
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        //获取请求的参数（办事材料）查看
        String username = req.getParameter("username");
        System.out.println("在Servlet1（柜台1）中查看参数（材料）："+username);

        //加盖章，，放到域数据中，并传递到servlet2 去查看
        req.setAttribute("key1", "柜台1的章111");

        //问路。。。请求转发到servlet2
        /**
            请求转发必须要以斜杠打头，/ 斜杠表示地址为：http://ip:port/工程名/ ，映射到IDEA代码的web目录
         */
        RequestDispatcher dispatcher = req.getRequestDispatcher("/servlet2");
        dispatcher.forward(req,resp);
    }
}
