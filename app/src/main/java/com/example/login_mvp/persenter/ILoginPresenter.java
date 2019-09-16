package com.example.login_mvp.persenter;

public interface ILoginPresenter {
    void clear();
    void doLogin(String name,String pass);
    void doProcessBar(int visibility);
}
