package com.lanou.bookstore.user.web.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AllFilter",urlPatterns = {})
public class AllFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object user = request.getSession().getAttribute("user");
        if(user != null ) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        response.sendRedirect(request.getContextPath()+"/jsps/user/login.jsp");


    }

    @Override
    public void destroy() {

    }
}
