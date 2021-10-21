package com.hs.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/static/customer/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        if (username==null){
//            resp.setCharacterEncoding("utf-8");
//            resp.setContentType("text/html; charset=UTF-8");
//            PrintWriter out = resp.getWriter();
//            out.write("未登录");
//            out.close();
            resp.sendRedirect("/static/warn.html");
        }else {
            filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
