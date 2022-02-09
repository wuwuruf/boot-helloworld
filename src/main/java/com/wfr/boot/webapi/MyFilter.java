package com.wfr.boot.webapi;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/img/*","/js/*"}) // /*是filter写法，/**是spring写法，都是拦截所有
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // filter初始化
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // filter工作
    }

    @Override
    public void destroy() {
        // filter销毁
    }
}
