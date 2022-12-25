package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.durante.study_servlets.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlets extends HttpServlet {
    // details.html의 a태그의 링크를 get방식으로 받아주기 위해 doGet선언
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        // 클라이언트가 요청하는 파라미터는 전부 request에서 들어온다.

        // input부분

        String questions_Uid = request.getParameter("QUESTIONS_UID");
        // 클라이언트가 던진 파라미터(HashMap 형태) 중 QUESTIONS_UID 키를 가진 밸류를 변수에 담음

        // business with DB and Class 부분
        PollWithDB pollWithDB = new PollWithDB();// 값을 받아오기 위해 인스턴스화
        HashMap<String, Object> question = null;
        ArrayList questionsUidList = null;
        ArrayList exampleUidList = null;
        ArrayList answersList = null;
        try {
            // HashMap<String, Object>으로 되어있는 데이터를 그대로 받아줌

            /* 각 변수에 값을 담음 */
            question = pollWithDB.getQuestion(questions_Uid);
            questionsUidList = pollWithDB.getQuestionsUidList();
            exampleUidList = pollWithDB.getExampleUidList(questions_Uid);
            answersList = pollWithDB.getAnswersList(exampleUidList);

            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
            System.out.println(questionsUidList);
            System.out.println(exampleUidList);
            System.out.println(answersList);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        // output with html 부분

        /**
         * 이 부분은 servlet에서 html까지 뽑아낼때사용. 지금은 jsp로 보내서 거기에서
         * html을 뽑아낼것이기 때문에 필요가 없다.
         * // response.setContentType("text/html;charset=UTF-8"); // 응답을 보낼 때 한글이 깨지지 않게
         * 해주는 것. 백엔드를 위한 것
         * // PrintWriter printWriter = response.getWriter();
         * // printWriter.close();
         */

        // request.setAttribute("question", question);
        // 받는 입장(jsp)에서 생각, request에 set으로 넣었으니 받는 입장에서는 get으로 받아올 수 있다.

        request.setAttribute("question", question);
        request.setAttribute("questionsUidList", questionsUidList);
        request.setAttribute("exampleUidList", exampleUidList);
        request.setAttribute("answersList", answersList);
        request.setAttribute("questionsUid", questions_Uid);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        requestDispatcher.forward(request, response);

    }

}
