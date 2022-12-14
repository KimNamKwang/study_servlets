package com.durante.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.durante.study_servlets.DatasInfo;
import com.durante.study_servlets.beans.MemberBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tablesBeanListServlets")
public class TablesBeanListServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 응답을 보낼 때 한글이 깨지지 않게 해주는 것. 백엔드를 위한 것

        // 여기서부터 액션을 취하는 부분
        DatasInfo datasInfo = new DatasInfo();
        MemberBean memberBean = datasInfo.getDataWithMemberBean();
        HashMap<String, Object> bundlesData = datasInfo.getBundleData();

        System.out.println(memberBean.getFirstName() + " " + memberBean.getSecondName()
                + " " + memberBean.getHandleName());

        // 여기까지

        // 여기서부터는 Display영역
        PrintWriter printWriter = response.getWriter();
        HashMap<String, String> searchForm = datasInfo.getSearchFormData();

        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8'>");
        printWriter.println("<title>" + searchForm.get("search_key") + "</title>");
        printWriter.println("<link");
        printWriter.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("rel='stylesheet'");
        printWriter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("crossorigin='anonymous'");
        printWriter.println("/>");
        printWriter.println("<link rel='stylesheet' href='./css/commons.css' />");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class='container'>");
        printWriter.println("<div class='fs-3'>Tables With Bean</div>");
        // printWriter.println("<div class='fs-4'>" + memberBean.getFirstName() + " " +
        // memberBean.getSecondName()
        // + " " + memberBean.getHandleName() + "</div>");

        MemberBean memberBean2 = (MemberBean) bundlesData.get("dataWithMemberBean");
        // cast 해준 부분(MemberBean). cast는 집어넣을때 object의 후손으로 넣었다가
        // 원래 가지고 있는 데이터 타입으로 빼준다
        printWriter.println("<div class='fs-4'>" + memberBean2.getFirstName() + " " + memberBean2.getSecondName()
                + " " + memberBean2.getHandleName() + "</div>");

        printWriter.println("<table class='table'>");
        printWriter.println("<thead>");
        printWriter.println("<tr>");
        printWriter.println("<th scope=>#</th>");
        printWriter.println("<th scope=>First</th>");
        printWriter.println("<th scope=>Last</th>");
        printWriter.println("<th scope=>Handle</th>");
        printWriter.println("</tr>");
        printWriter.println("</thead>");
        printWriter.println("<tbody>");

        // String만 출력
        // for (int i = 0; i < tablesListWithString.size(); i++) {
        // printWriter.println("<tr>");
        // printWriter.println("<th scope=>" + (i + 1) + "</th>");
        // // printWriter.println("<td>Mark</td>");
        // // printWriter.println("<td>Otto</td>");
        // String handle = tablesListWithString.get(i);
        // printWriter.println("<td>" + handle + "</td>");
        // printWriter.println("</tr>");
        // }

        ArrayList<MemberBean> dataListWithMemberBean = (ArrayList<MemberBean>) bundlesData
                .get("dataListWithMemberBean");

        for (int i = 0; i < dataListWithMemberBean.size(); i++) {
            // 넣은 순서의 반대로 해체해서 데이터를 꺼낸다
            MemberBean memberBean3 = dataListWithMemberBean.get(i);
            printWriter.println("<tr>");
            printWriter.println("<th scope=>" + (i + 1) + "</th>");
            // printWriter.println("<td>Mark</td>");
            // printWriter.println("<td>Otto</td>");
            String handle = memberBean3.getHandleName();
            printWriter.println("<td>" + memberBean3.getFirstName() + "</td>");
            printWriter.println("<td>" + memberBean3.getSecondName() + "</td>");
            printWriter.println("<td>" + handle + "</td>");
            printWriter.println("</tr>");
        }

        printWriter.println("</tbody>");
        printWriter.println("</table>");
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
