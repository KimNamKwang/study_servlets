package com.durante.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/FormsSelectsServlet")
public class FormsSelectsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        String message = "form selects";

        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<title>" + message + "</title>");
        printWriter.println("<link");
        printWriter.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("rel='stylesheet'");
        printWriter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("crossorigin='anonymous'");
        printWriter.println("/>");
        printWriter.println("<link rel='stylesheet' href='./css/commons.css' />");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class='fs-3'>form selects</div>");
        printWriter.println("<div>");
        printWriter.println("<label for='' class='form-label'>select multiple</label>");
        printWriter.println("<select multiple class='form-select' aria-label=''>");
        printWriter.println("<option selected>Open this select menu</option>");
        printWriter.println("<option value='M01'>One</option>");
        printWriter.println("<option selected value='M02'>Two</option>");
        printWriter.println("<option value='M03'>Three</option>");
        printWriter.println("<option value='M04'>Four</option>");
        printWriter.println("<!--위처럼 value를 줘서 값이 넘어갈때 value가 넘어가게.-->");
        printWriter.println("<!--ctrl누르면 여러개 선택가능-->");
        printWriter.println("<!--selected 여러개도 줄 수 있음.-->");
        printWriter.println("</select>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println("<label for='' class='form-label'>select</label>");
        printWriter.println("<select class='form-select' aria-label=''>");
        printWriter.println("<option>Open this select menu</option>");
        printWriter.println("<option value='M01'>One</option>");
        printWriter.println("<option value='M02'>Two</option>");
        printWriter.println("<option value='M03' selected>Three</option>");
        printWriter.println("<!--selected를 어디다 주느냐에 따라 처음 나오는 선택지가 다름.-->");
        printWriter.println("</select>");
        printWriter.println("</div>");

        printWriter.println("<script");
        printWriter.println("src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println("crossorigin='anonymous'");
        printWriter.println("></script>");
        printWriter.println("</body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
