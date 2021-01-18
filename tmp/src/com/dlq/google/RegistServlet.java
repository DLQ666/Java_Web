package com.dlq.google;

import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //获取Session中的验证码
        String token = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //马上删除 Session中的验证码
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);

        String username = request.getParameter("username");
        String code = request.getParameter("code");
        if (token != null && token.equalsIgnoreCase(code)){
            System.out.println("保存到数据库："+username);
            response.sendRedirect(request.getContextPath()+"/ok.jsp");
        }else {
            System.out.println("请不要提交表单！");
        }
    }
}
