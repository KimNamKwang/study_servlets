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

@WebFilter("/simple/*") /* URL창에 /simple/로 들어오는 모든 것 */
public class SendRedirectFilter implements Filter {

    @Override
    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteAddr());

        /* url을 빼내기 위해 HttpServletRequest으로 선언 */
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String uri = httpServletRequest.getRequestURI();

        if (uri.endsWith("Servlets")) {
            /* index.html로 보내줬다가 */
            httpServletResponse.sendRedirect("index.html");
        } else {
            /* chain이 url 서블릿으로 넘겨주는 역할. 곧 Dispatcher */
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

}
