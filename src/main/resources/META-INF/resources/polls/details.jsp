<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.HashMap"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
  </head>
  <body>
    <!--HashMap 자체는 key는 string value는 object로(어떤 타입이 들어갈지 몰라서) 되어 있다.-->
    <%
     HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question");
      %>
    <div>
      <a href="/polls/PollServlet?QUESTIONS_UID=Q1">Q1</a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q2">Q2</a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q3">Q3</a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q4">Q4</a> 
      <a href="/polls/PollServlet?QUESTIONS_UID=Q5">Q5</a> 
    </div>
    <div>
      <%= question.get("ORDERS") %>.<%= (question.get("QUESTIONS")%>
    </div>
    <div>(1) 전혀 아니다</div>
    <div>(2) 아니다</div>
    <div>(3) 보통이다</div>
  </body>
</html>
