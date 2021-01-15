package com.dlq.book.controller;

import com.dlq.book.pojo.User;
import com.dlq.book.service.UserService;
import com.dlq.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //验证用户名 密码
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null){
            System.out.println("登录失败！");
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }else {
            System.out.println("登录成功！");
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }

    }

}
