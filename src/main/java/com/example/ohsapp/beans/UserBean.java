package com.example.ohsapp.beans;

public class UserBean {
    private String name;
    private String employmentNumber;
    private String admin;
    private boolean checkAdmin = false;
    private String mail;
    private String phoneNumber;
    private String userName;
    private String password;

    public UserBean(String name, String employmentNumber, String admin) {
        this.name = name;
        this.employmentNumber = employmentNumber;
        this.admin = admin;
    }

    public UserBean(String employmentNumber, String name, String mail, String phoneNumber, String userName, String password, String admin) {
        this.name = name;
        this.employmentNumber = employmentNumber;
        this.admin = admin;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmployeeId() {
        return employmentNumber;
    }

    public void setEmployeeId(String employeeId) {
        this.employmentNumber = employeeId;
    }

    public boolean isCheckAdmin() {
        return checkAdmin;
    }

    public void initiateCheckAdmin() {
        if (this.admin.equals("1")) {
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