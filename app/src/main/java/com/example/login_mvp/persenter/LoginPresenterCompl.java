package com.example.login_mvp.persenter;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.example.login_mvp.model.IUser;
import com.example.login_mvp.model.User;
import com.example.login_mvp.view.ILoginView;
import java.util.Objects;

public class LoginPresenterCompl implements ILoginPresenter {
    private ILoginView mILoginView;
    private IUser mIUser;
    private Handler mHandler;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public LoginPresenterCompl(ILoginView ILoginView) {
        mILoginView = ILoginView;
        initUser();
        mHandler = new Handler(Objects.requireNonNull(Looper.myLooper()));
    }

    private void initUser() {
        mIUser = new User("Huy","123");
    }

    @Override
    public void clear() {
        mILoginView.clearText();
    }

    @Override
    public void doLogin(String name, String pass) {
        boolean isLoginSuccess = true;
        final int code = mIUser.checkValidity(name,pass);
        if (code!=0) isLoginSuccess = false;
        final Boolean result = isLoginSuccess;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mILoginView.onLoginResult(result,code);
            }
        },500);
    }

    @Override
    public void doProcessBar(int visibility) {
        mILoginView.onSetProcessBar(visibility);
    }
}
