package com.durante.study_servlets;

import java.util.ArrayList;
import java.util.HashMap;

import com.durante.study_servlets.beans.MemberBean;

public class DatasInfo {
    public HashMap<String, String> getSearchFormData() {
        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "남광");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    public ArrayList<String> getTablesListWithString() {
        ArrayList<String> tablesListWithString = new ArrayList<String>();
        tablesListWithString.add("@mdo");
        tablesListWithString.add("@fat");
        tablesListWithString.add("@twitter");
        return tablesListWithString;
    }

    public HashMap<String, Object> getBundleData() {

        DatasInfo datasInfo = new DatasInfo();
        HashMap<String, String> searchForm = datasInfo.getSearchFormData();
        ArrayList<String> tablesListWithString = datasInfo.getTablesListWithString();

        HashMap<String, Object> bundlesData = new HashMap<>();
        bundlesData.put("searchForm", searchForm);
        bundlesData.put("tablesListWithString", tablesListWithString);

        bundlesData.put("dataWithMemberBean", datasInfo.getDataWithMemberBean());
        bundlesData.put("dataListWithMemberBean", datasInfo.getDataListWithMemberBean());

        return bundlesData;
    }
    // <String, String> 자리에 하나는 HaspMap, 하나는 Array를 넣어준다.

    public MemberBean getDataWithMemberBean() {
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("Otto");
        memberBean.setHandleName("@mdo");

        return memberBean;
    }

    public ArrayList<MemberBean> getDataListWithMemberBean() {
        ArrayList<MemberBean> membersList = new ArrayList<>();
        MemberBean memberBean = new MemberBean();
        memberBean.setFirstName("Mark");
        memberBean.setSecondName("Otto");
        memberBean.setHandleName("@mdo");
        membersList.add(memberBean);

        MemberBean memberBean02 = new MemberBean();
        memberBean02.setFirstName("Jacob");
        memberBean02.setSecondName("Thorton");
        memberBean02.setHandleName("@fat");
        membersList.add(memberBean02);

        MemberBean memberBean03 = new MemberBean();
        memberBean03.setFirstName("Larry");
        memberBean03.setSecondName("Bird");
        memberBean03.setHandleName("@Twitter");
        membersList.add(memberBean03);
        return membersList;
    }
}
