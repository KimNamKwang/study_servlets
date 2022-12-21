package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollsServlet")
public class DetailServlets extends HttpServlet {
    // details.html의 a태그의 링크를 get방식으로 받아주기 위해 doGet선언
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 클라이언트가 요청하는 파라미터는 전부 request에서 들어온다.

        // input부분

        String questions_Uid = request.getParameter("QUESTIONS_UID");
        // 클라이언트가 던진 파라미터(HashMap 형태) 중 QUESTIONS_UID 키를 가진 밸류를 변수에 담음

        // business with DB and Class 부분

        // output with html 부분
        response.setContentType("text/html;charset=UTF-8"); // 응답을 보낼 때 한글이 깨지지 않게 해주는 것. 백엔드를 위한 것
        PrintWriter printWriter = response.getWriter();
        printWriter.close();

    }

}
