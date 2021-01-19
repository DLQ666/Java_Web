package com.dlq.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *@program: Java_Web
 *@description:
 *@author: Hasee
 *@create: 2021-01-19 11:02
 */
public class AdminFilter implements Filter {

    public AdminFilter(){
        System.out.println("1、Filter构造器方法AdminFilter()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2、Filter的init(FilterConfig filterConfig)初始化");

        //1、获取web.xml中配置的Filter的名称filter-name的内容
        System.out.println("filter-name的值是："+filterConfig.getFilterName());
        //2、获取在web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username的值是："+filterConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是："+filterConfig.getInitParameter("url"));
        //3、获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * doFilter 方法：专门用于拦截请求。可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("3、Filter的doFilter() 过滤方法");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Object user = request.getSession().getAttribute("user");
        // 如果等于 null， 说明还没有登录
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
            return;
        }else {
            //让程序继续往下访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4、Filter的destroy() 销毁方法");
    }
}
