package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.durante.study_servlets.DatasInfo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherJSP/TablesListServlets")
public class DispatcherJSPTablesListServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 응답을 보낼 때 한글이 깨지지 않게 해주는 것. 백엔드를 위한 것
        DatasInfo datasInfo = new DatasInfo();
        ArrayList<String> tablesListWithString = datasInfo.getTablesListWithString();
        HashMap<String, String> searchForm = datasInfo.getSearchFormData();

        // JSP에 보내주기 위한 작업
        request.setAttribute("tablesListWithString", tablesListWithString);
        request.setAttribute("searchForm", searchForm);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tables_list.jsp");
        requestDispatcher.forward(request, response);
    }
}
