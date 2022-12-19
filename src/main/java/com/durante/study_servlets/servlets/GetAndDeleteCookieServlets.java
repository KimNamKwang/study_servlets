package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet(urlPatterns = "/cookies/getAndDeleteServlets")
public class GetAndDeleteCookieServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8"); // 응답을 보낼 때 한글이 깨지지 않게 해주는 것. 백엔드를 위한 것
    

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>Get And Delete CookieServlets</div>");
        
        // get Cookie
       Cookie cookies[] = request.getCookies();
       for(Cookie cookie: cookies){
       String name =  cookie.getName(); // key
       String value = cookie.getValue(); // value
        printWriter.println("<div> Cookie Name :" +name+", value :" +value+ "</div>");
        
        //쿠키 삭제(secondName만)
        if(name.equals("secondName")){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }
        printWriter.close();
    }
}

