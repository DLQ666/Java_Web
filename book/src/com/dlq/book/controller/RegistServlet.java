package com.dlq.book.controller;

import com.dlq.book.pojo.User;
import com.dlq.book.service.UserService;
import com.dlq.book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        //检查验证码 == 写死，为 abcde
        if ("abcde".equalsIgnoreCase(code)) {

        } else {
            System.out.println("验证码[" + code + "]错误");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
        }

        //检查用户名是否正确
        boolean b = userService.existUsername(username);
        if (b){
            //用户名不可用
            System.out.println("用户名["+username+"]已存在！");
            //跳回注册页面
            request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
        }else {
            //用户名可用
            //调用service层保存数据库
            userService.registerUser(new User(null,username,password,email));
            System.out.println("注册成功");
            //跳转注册成功页面 - regist_success.html
            request.getRequestDispatcher("/pages/user/regist_success.html").forward(request, response);
        }
    }
}
