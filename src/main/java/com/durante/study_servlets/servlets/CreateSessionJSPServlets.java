package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createJSPServlets?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/createJSPServlets")
public class CreateSessionJSPServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8"); // 응답을 보낼 때 한글이 깨지지 않게 해주는 것. 백엔드를 위한 것

        // session
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession httpSession = null;
        HttpSession httpSession_false = null;

        // JSessionID가 있을 때
        // httpSession = request.getSession(); //존재하면 인스턴스화 
        // httpSession_false = request.getSession(false); //무조건 인스턴스화 
        
        // 없을 때
        // httpSession_false = request.getSession(false);
        // httpSession = request.getSession(); //무조건 인스턴스화
        /** 최초 로그인 시에는 이걸 사용, 하지만 최초에 위의 request.getSession(false); 
         * 를 if문으로 체크해야함. 로그인되어있는지 아닌지 체크하기 위해*/
        

        String path = null;
        // 로그인 되는 상태
        if ("yojulab".equals(username) && "1234".equals(password)) {
            httpSession_false = request.getSession(false); //존재하면 인스턴스화 
            if(httpSession == null){
                httpSession = request.getSession(); //무조건 인스턴스화 
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);

            }
            path = "/session/check_Login.jsp";

        } else {
            // 로그아웃
            httpSession = request.getSession(false); //존재하면 인스턴스화 
            if(httpSession != null){
                httpSession.invalidate();//JSessionID삭제

            }
            path = "/session/check_Logout.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
