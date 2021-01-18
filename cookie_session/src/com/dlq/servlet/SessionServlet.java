package com.dlq.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 先获取 Session 对象
        HttpSession session = request.getSession();
        //设置当前Session 马上超时
        session.invalidate();
        response.getWriter().write("当前Session的已经设置为超时（无效，马上超时） ");
    }

    protected void life3(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 先获取 Session 对象
        HttpSession session = request.getSession();
        //设置当前Session 3秒后超时
        session.setMaxInactiveInterval(3);
        response.getWriter().write("当前Session的已经设置为3秒后超时 ");
    }

    protected void defaultLife(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("Session的默认超时时长为："+maxInactiveInterval+" 秒 ");
    }

    protected void setAttribute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getSession().setAttribute("key1", "value1");
        response.getWriter().write("已经往Session中保存了数据");
    }
    protected void getAttribute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Object key1 = request.getSession().getAttribute("key1");
        response.getWriter().write("从Session中获取key1的数据是："+key1);
    }

    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        BaseServlet baseServlet = new SessionServlet();
        //创建和获取Session对象
        HttpSession session = request.getSession();
        //判断 当前session会话，是否是新创建出来的
        boolean aNew = session.isNew();
        //获取Session会话的唯一标识
        String id = session.getId();

        response.getWriter().write("得到的Session，它的id是："+id +"<br />");
        response.getWriter().write("这个Session是否是新创建的："+ session.isNew()+"<br />");
    }

}
