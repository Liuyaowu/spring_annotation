package com.mobei.sb.originannotation;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/css/*", "/images/*"})
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter doFilter");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("filter destroy");
    }

}
