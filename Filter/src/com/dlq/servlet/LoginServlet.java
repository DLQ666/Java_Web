package com.dlq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("dlq123".equals(username) && "qweqwe".equals(password)){
            request.getSession().setAttribute("user", username);
            response.getWriter().write("哈哈哈哈哈，登录成功啦！！！");
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
