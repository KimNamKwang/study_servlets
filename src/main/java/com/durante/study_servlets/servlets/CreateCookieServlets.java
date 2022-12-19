package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet(urlPatterns = "/cookies/createServlets")
public class CreateCookieServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8"); // 응답을 보낼 때 한글이 깨지지 않게 해주는 것. 백엔드를 위한 것
    
        // Cookie
       Cookie cookie_first = new Cookie("firstName", "Durante");
       Cookie cookie_second = new Cookie("secondName", "Dante");
        response.addCookie(cookie_first);
        response.addCookie(cookie_second);
        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>CreateCookieServlets</div>");;
        printWriter.close();
    }
}

