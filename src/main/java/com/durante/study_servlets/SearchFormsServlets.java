package com.durante.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "SearchFormServlets")
public class SearchFormsServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        String title = "Search";
        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<title>" + title + "</title>");
        printWriter.println("<link");
        printWriter.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("rel='stylesheet'");
        printWriter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("crossorigin='anonymous'/>");
        printWriter.println("<link rel='stylesheet' href='./css/commons.css' />");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class='container'>");
        printWriter.println("<div class='fs-3'>Search Form</div>");
        printWriter.println("<form action=''>");
        printWriter.println("<div>");
        printWriter.println("<label class='form-label' for=''>Search With Name</label>");
        printWriter.println("<input");
        printWriter.println("class='form-control'");
        printWriter.println("type='email'");
        printWriter.println("placeholder='Input Name'");
        printWriter.println("name=''");
        printWriter.println("id=''/>");
        printWriter.println("</div>");
        printWriter.println("</form>");
        printWriter.println("</div>");

        printWriter.println("<script");
        printWriter.println("src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println("crossorigin='anonymous'>");
        printWriter.println("</script>");
        printWriter.println("</body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
