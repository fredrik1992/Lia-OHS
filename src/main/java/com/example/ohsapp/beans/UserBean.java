package com.example.ohsapp.beans;

public class UserBean {
    private String name;
    private String employementNumber;
    private String admin;
    private boolean checkAdmin = false;
    private String mail;
    private String phoneNumber;
    private String userName;
    private String password;

    public UserBean(String name, String employementNumber,String admin) {
        this.name = name;
        this.employementNumber = employementNumber;
        this.admin = admin;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmployeeId() {
        return employementNumber;
    }

    public void setEmployeeId(String employeeId) {
        this.employementNumber = employeeId;
    }

    public boolean isCheckAdmin() {
        return checkAdmin;
    }

    public void initiateCheckAdmin() {
        if(this.admin.equals("1")){
            this.checkAdmin = true;
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}