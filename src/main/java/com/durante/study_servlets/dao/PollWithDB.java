package com.durante.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB {
    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException {

        // DB로그인을 위해 인스턴스화
        Commons commons = new Commons();
        // 쿼리문을 넣기 위해 Statement 가져옴
        Statement statement = commons.getStatement();

        // parameter로 들어오는 questionsUid 로 QUESTIONS_UID를 찾는 쿼리
        String query = "SELECT * FROM QUESTIONS_LIST" +
                " WHERE QUESTIONS_UID = '" + questionsUid + "'";

        // String queryForAnswersList = "SELECT * FROM EXAMPLE_LIST WHERE EXAMPLE_UID IN
        // (SELECT EXAMPLE_UID FROM ANSWERS WHERE QUESTIONS_UID = 'Q1')";

        ResultSet resultSet = statement.executeQuery(query);
        // ResultSet resultSetForAnswersList =
        // statement.executeQuery(queryForAnswersList);

        // DB에서 받아온 결과를 HashMap으로 받음.
        HashMap<String, Object> result = null;

        while (resultSet.next()) {
            result = new HashMap<>();
            result.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            result.put("ORDERS", resultSet.getInt("ORDERS"));
        }
        return result;
    }

    public HashMap<String, Object> getQuestionsListAll() throws SQLException {
        // DB로그인을 위해 인스턴스화
        Commons commons = new Commons();

        // 쿼리문을 넣기 위해 Statement 가져옴
        Statement statement = commons.getStatement();

        // QUESTIONS_LIST를 모두 select
        String query = "SELECT * FROM QUESTIONS_LIST";

        ResultSet resultSet = statement.executeQuery(query);

        HashMap<String, Object> resultForAnswerList = null;

        ArrayList arrayListForAnswers;

        // HashMap에 한 row씩 담아서 ArrayList에 담아주고 ArrayList를 return해줘야 한다

        for(int i = 0; i < ){

        }
        
        while (resultSet.next()) {
            resultForAnswerList = new HashMap<>();
            resultForAnswerList.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            resultForAnswerList.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            resultForAnswerList.put("ORDERS", resultSet.getInt("ORDERS"));
        }
        return resultForAnswerList;
    }
}
