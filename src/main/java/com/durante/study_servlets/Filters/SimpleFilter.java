package com.durante.study_servlets.Filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*") /* 모든 웹사이트에서 들어오는것을 다 필터링 하겠다는 의미. 아무것도 안 써주는것과 동일함 */
public class SimpleFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteAddr());
        chain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
