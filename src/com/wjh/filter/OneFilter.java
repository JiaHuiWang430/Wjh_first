package com.wjh.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = null;
        //因为servletRequest不是HttpServletRequest类型的，不可以调用某些方法，所以强制转换为这个类型的
        HttpServletRequest requestHS = (HttpServletRequest) servletRequest;

        //得到请求行中浏览器地址uri
        String uri = requestHS.getRequestURI();
        //如果地址中含有login，那么无条件可以访问
        if (uri.indexOf("login")!=-1){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //如果session不为null，那么表示有session对象，可以进入
        session = requestHS.getSession(false);
        if (session!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        requestHS.getRequestDispatcher("/login_error.html").forward(servletRequest,servletResponse);
    }
}
