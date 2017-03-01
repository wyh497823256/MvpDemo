package com.h.mvpdemo.logic.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.h.mvpdemo.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    EditText userName;
    EditText password;

    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        mPresenter = new MainPresenter(this);


    }

    public void login(View v) {
        mPresenter.login();
    }

    @Override
    public void loginSuccess() {
        //成功跳转
        showMessage("跳转");
    }

    @Override
    public String getUserName() {
        return userName.getText().toString().trim();
    }

    @Override
    public String getPassWord() {
        return password.getText().toString().trim();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
