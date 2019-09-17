package com.example.login_mvp.screen.Login;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.example.login_mvp.data.model.User;
import java.util.Objects;

public class LoginPresenterCompl implements ILoginContract.Presenter {
    private ILoginContract.View mView;
    private User mUser;
    private Handler mHandler;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    LoginPresenterCompl(ILoginContract.View View) {
        mView = View;
        initUser();
        mHandler = new Handler(Objects.requireNonNull(Looper.myLooper()));
    }

    private void initUser() {
        mUser = new User("Huy","123");
    }

    @Override
    public void clear() {
        mView.clearText();
    }

    @Override
    public void doLogin(String name, String pass) {
        boolean isLoginSuccess = true;
        final int code = mUser.checkValidity(name,pass);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.onLoginResult(result,code);
            }
        },500);
    }

    @Override
    public void doProcessBar(int visibility) {
        mView.onSetProcessBar(visibility);
    }

    @Override
    public void setView(ILoginContract.View view) {
        mView = view;
    }
}
