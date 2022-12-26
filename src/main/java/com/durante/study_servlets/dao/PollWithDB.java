package com.durante.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.protocol.Resultset;

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

    /* 강사님 버전 */
    public ArrayList<HashMap<String, Object>> getAnswersList(String questionUid) throws SQLException {
        // DB로그인을 위해 인스턴스화
        Commons commons = new Commons();
        // 쿼리문을 넣기 위해 Statement 가져옴
        Statement statement = commons.getStatement();

        String query = "SELECT ANSWERS.QUESTIONS_UID, EXAMPLE_LIST.ORDERS," +
                " EXAMPLE_LIST.EXAMPLE FROM ANSWERS INNER JOIN EXAMPLE_LIST " +
                " ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID" +
                " WHERE QUESTIONS_UID = '" + questionUid + "' ORDER BY QUESTIONS_UID ";

        ResultSet resultSet = statement.executeQuery(query);
        HashMap<String, Object> answer = new HashMap<String, Object>();
        ArrayList<HashMap<String, Object>> answer_list = new ArrayList<HashMap<String, Object>>();

        // Row가 하나여도 while문은 돌려야한다
        while (resultSet.next()) {
            answer.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            answer.put("ORDERS", resultSet.getInt("ORDERS"));
            answer.put("EXAMPLE", resultSet.getString("EXAMPLE"));

            answer_list.add(answer);
        }
        return answer_list;
    }

    /* QuestionsUid 를 가져오는 Function */
    public ArrayList getQuestionsUidList() throws SQLException {

        // DB로그인을 위해 인스턴스화
        Commons commons = new Commons();

        // 쿼리문을 넣기 위해 Statement 가져옴
        Statement statement = commons.getStatement();

        String query = "SELECT QUESTIONS_UID FROM QUESTIONS_LIST";

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList questionsUidList = new ArrayList<>();

        while (resultSet.next()) {
            // arraylist에 resultset에서 값을 가져와 넣음.
            questionsUidList.add(resultSet.getString("questions_uid"));
        }
        return questionsUidList;
    }

    /* questionsUid를 입력받아서 ExampleUid를 가져오는 Function */
    public ArrayList getExampleUidList(String questionsUid) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        String query = "SELECT EXAMPLE_UID FROM ANSWERS WHERE QUESTIONS_UID='" + questionsUid + "'";

        ResultSet resultSet = statement.executeQuery(query);
        ArrayList exampleUidList = new ArrayList<>();
        while (resultSet.next()) {
            exampleUidList.add(resultSet.getString("EXAMPLE_UID"));
        }
        return exampleUidList;
    }

    /*
     * ArrayList인 exampleUidList에서 ExampleUid를 가져와 답항을 가져오는 Function
     * 의문점 - getExampleUidList 펑션의 return값인 exampleUidList를 호출없이 어떻게 사용가능한지
     */
    public ArrayList getAnswersList(ArrayList exampleUidList) throws SQLException {
        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        String exampleUid;
        ArrayList examplesList = new ArrayList<>();

        for (int i = 0; i < exampleUidList.size(); i++) {

            exampleUid = (String) exampleUidList.get(i);/*
                                                         * exampleUidList에서
                                                         */
            String query = "select example from example_list where example_uid='" + exampleUid + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // resultSet의 next가 있을때까지 ArrayList에 담음
                examplesList.add(resultSet.getString("EXAMPLE"));
            }
        }

        return examplesList;
    }
}
