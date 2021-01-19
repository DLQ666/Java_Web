package com.dlq.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException
    {
        System.out.println("前置代码2");
        chain.doFilter(req, resp);
        System.out.println("后置代码2");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
