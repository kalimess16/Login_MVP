package com.example.login_mvp.screen;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login_mvp.R;

public class MainActivity extends AppCompatActivity implements ILoginContract.View {

    private EditText mUserName, mPassword;
    private ProgressBar mProgressBar;
    private ILoginContract.Presenter mLoginPresenter;
    private Button mLogin, mClean;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    // get ID
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initView() {
        mUserName = findViewById(R.id.text_login_username);
        mPassword = findViewById(R.id.text_login_password);
        mProgressBar = findViewById(R.id.progress_login);
        mLogin = findViewById(R.id.button_login);
        mClean = findViewById(R.id.btn_clear);
        mLoginPresenter = new LoginPresenterCompl(this);
        mLoginPresenter.doProcessBar(View.INVISIBLE);
    }

    public void onClick(View view) {
        int getID = view.getId();
        if (getID == R.id.button_login) {
            lockView();
            String name = mUserName.getText().toString();
            String pass = mPassword.getText().toString();
            mLoginPresenter.doLogin(name, pass);
        } else {
            mLoginPresenter.clear();
        }
    }

    private void lockView() {
        mProgressBar.setVisibility(View.VISIBLE);
        mUserName.setEnabled(false);
        mPassword.setEnabled(false);
        mLogin.setEnabled(false);
        mClean.setEnabled(false);
    }

    @Override
    public void clearText() {
        mUserName.setText("");
        mPassword.setText("");
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mLoginPresenter.doProcessBar(View.INVISIBLE);
        mClean.setEnabled(true);
        mLogin.setEnabled(true);
        if (result) {
            Toast.makeText(this, "Login Success " , Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Fail Somethings " + code, Toast.LENGTH_SHORT).show();
        }
        unLock();
    }

    private void unLock() {
        mUserName.setEnabled(true);
        mPassword.setEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSetProcessBar(int visibility) {
        mProgressBar.setVisibility(visibility);
    }
}
