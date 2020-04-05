package cn.shine365.demo.day01.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author taobaibai
 * @create 2020-03-31 21:24
 */
//@WebFilter(urlPatterns = "/api/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init loginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter loginFilter");
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse)servletResponse;
        String username = req.getParameter("username");
        if("taobaibai".equals(username)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            resp.sendRedirect("/index2.html");
            return;
        }

    }

    @Override
    public void destroy() {
        System.out.println("destory loginFilter");
    }
}
