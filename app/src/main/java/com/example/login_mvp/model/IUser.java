package com.example.login_mvp.model;

public interface IUser {
    String getUserName();
    String getUserPassword();
    int checkValidity(String name,String pass);
}
