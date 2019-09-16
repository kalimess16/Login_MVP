package com.example.login_mvp.view;

public interface ILoginView {
    void clearText();
    void onLoginResult(Boolean result,int code);
    void onSetProcessBar(int visibility);
}
