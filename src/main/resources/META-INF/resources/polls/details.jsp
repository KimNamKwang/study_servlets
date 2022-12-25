<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.HashMap, java.util.ArrayList;"%>
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
    ArrayList questionsUidList = (ArrayList) request.getAttribute("questionsUidList");
		ArrayList answersList = (ArrayList) request.getAttribute("answersList");
		String questionsUid = (String) request.getAttribute("questionsUid");
%> 


<%-- 주석처리  --%>


<div> 
  <%  for (int i = 0; i < questionsUidList.size(); i++) { %>
  <a href="/polls/PollServlet?QUESTIONS_UID= <%= questionsUidList.get(i)%>"><%= questionsUidList.get(i)%></a> / 
  <%  } %>
  <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS")%>
</div>
<div>
  <% for (int i = 0; i <answersList.size(); i++) { %>
    <%= i %> <%= questionsUid %>
    <%= i %> <%= answersList.get(i) %>
</div>
  </body>
</html>
