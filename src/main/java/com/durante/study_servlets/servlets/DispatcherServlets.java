package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherServlets")

public class DispatcherServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String hiddenParam = request.getParameter("hiddenParam");

        // /dispatcherServlets?hiddenParam=SearchFormServlets 라고 url에 입력해야함
        if ("SearchFormServlets".equals(hiddenParam)) {
            // hiddenParam이 "SearchFormServlets"이면 아래에서 response에 url실어서 보냄
            response.sendRedirect("/SearchFormServlets");

        }
        // /dispatcherServlets?hiddenParam=createCookieServlets 라고 입력하는 경우
        else if ("createCookieServlets".equals(hiddenParam)) {
            request.setAttribute("firstName", "yojulab");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cookies/createServlets");
            requestDispatcher.forward(request, response);
        } else { // hiddenParam의 값이 아니라면 아래처럼 normal한 화면 출력

            // normal display
            String message = "DispatcherServlets With Message";
            PrintWriter printWriter = response.getWriter();

            printWriter.println("<html lang='en'>");
            printWriter.println("<head>");
            printWriter.println("<title>" + message + "</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<button>Call DispatcherServlets</button>");
            printWriter.println("</body>");
            printWriter.println("</html>");

            printWriter.close();
        }
    }
}
