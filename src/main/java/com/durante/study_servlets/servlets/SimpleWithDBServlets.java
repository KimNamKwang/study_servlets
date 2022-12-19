package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.durante.study_servlets.dao.SimpleWithDB;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simple/WithDBServlets")
public class SimpleWithDBServlets extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
      //business 부분
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        simpleWithDB.getList();
       //display 부분
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>SimpleWithDBServlets</div>");
        printWriter.close();
    }
}
