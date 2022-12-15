package com.durante.study_servlets;

import java.util.ArrayList;
import java.util.HashMap;

public class DatasInfo {
    HashMap<String, String> getSearchFormData() {
        HashMap<String, String> searchForm = new HashMap<String, String>();
        searchForm.put("search_key", "Search Title");
        searchForm.put("name", "남광");
        searchForm.put("id", "ID0001");
        return searchForm;
    }

    ArrayList<String> getTablesListWithString() {
        ArrayList<String> tablesListWithString = new ArrayList<String>();
        return tablesListWithString;
    }
}
