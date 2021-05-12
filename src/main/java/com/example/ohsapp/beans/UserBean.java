package com.example.ohsapp.beans;

public class UserBean {


    private String name;
    private String employeeId;
    private boolean admin;

    public UserBean(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
