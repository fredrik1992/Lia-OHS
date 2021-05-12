package com.example.ohsapp.beans;

public class UserBean {



    private String name;
    private String employeeId;
    private String admin;
    private boolean checkAdmin = false;

    public UserBean(String name, String employeeId,String admin) {
        this.name = name;
        this.employeeId = employeeId;
        this.admin = admin;
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

    public boolean isCheckAdmin() {
        return checkAdmin;
    }

    public void initiateCheckAdmin() {
        if(this.admin.equals("1")){
            this.checkAdmin = true;
        }
    }
}
