package com.example.login_mvp.model;

public class User implements IUser {
    private String userName,userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public int checkValidity(String name, String pass) {
       if (name == null || pass ==null || !name.equals(getUserName()) || !pass.equals(getUserPassword())) return -1;
        return 0;
    }
}
