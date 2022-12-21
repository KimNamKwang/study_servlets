package com.durante.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class PollWithDB {
    public void getQuestion(String questionsUid) throws SQLException {

        // DB로그인을 위해 인스턴스화
        Commons commons = new Commons();
        // 쿼리문을 넣기 위해 Statement 가져옴
        Statement statement = commons.getStatement();

        // parameter로 들어오는 questionsUid 로 QUESTIONS_UID를 찾는 쿼리
        String query = "SELECT * FROM QUESTIONS_LIST" +
                "WHERE QUESTIONS_UID = '" + questionsUid + "'";

        ResultSet resultSet = statement.executeQuery(query);

        // DB에서 받아온 결과를 HashMap으로 받음.
        HashMap<String, Object> result;

        while (resultSet.next()) {
            resultSet.getString("QUESTIONS_UID");
            resultSet.getString("QUESTIONS");
            resultSet.getInt("ORDERS");
        }
    }
}
