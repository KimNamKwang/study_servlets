package com.durante.study_servlets.beans;

public class MemberBean {
    protected String firstName;
    protected String secondName;
    protected String handleName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return this.secondName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public String getHandleName() {
        return this.handleName;
    }

}
