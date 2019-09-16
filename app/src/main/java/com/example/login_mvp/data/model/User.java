package com.example.login_mvp.data.model;

public class User{
    private String userName,userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int checkValidity(String name,String pass){
        if (name == null || pass == null || !name.equals(getUserName()) || !pass.equals(getUserPassword())) return 1;
        return 0;
    }
}
