package com.example.login_mvp.screen;

import com.example.login_mvp.utils.BasePresenter;

public interface ILoginContract {
    /**
     * View
     */

    interface View {
        void clearText();

        void onLoginResult(Boolean result, int code);

        void onSetProcessBar(int visibility);
    }

    /**
     * Presenter
     */
    interface Presenter extends BasePresenter<View> {
        void clear();

        void doLogin(String name, String pass);

        void doProcessBar(int visibility);
    }
}
