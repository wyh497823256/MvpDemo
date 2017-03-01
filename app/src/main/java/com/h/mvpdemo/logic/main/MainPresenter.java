package com.h.mvpdemo.logic.main;

import android.text.TextUtils;

import com.h.mvpdemo.entity.ResultEntity;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * com.h.mvpdemo.logic.main/MvpDemo
 * 作者：Harvey on 2017/3/1 17:18
 * 邮箱：497823256@qq.com
 * 说明：
 * 修改：
 * 修改说明：
 */
public class MainPresenter implements MainContract.Presenter {

    private MainModelImpl mMainModel = new MainModelImpl();

    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        this.mView = view;
    }

    @Override
    public void login() {
        String userName = mView.getUserName();
        if (TextUtils.isEmpty(userName)) {
            mView.showMessage("用户名不能为空");
            return;
        }
        String password = mView.getPassWord();
        if (TextUtils.isEmpty(password)) {
            mView.showMessage("密码不能为空");
            return;
        }
        //登录
        mMainModel.login(userName, password)
                .subscribeOn(Schedulers.newThread())//启动线程
                .observeOn(AndroidSchedulers.mainThread())//UI线程
                .subscribe(new Observer<ResultEntity>() {
                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        //错误异常
                        mView.showMessage(e.getMessage());
                    }

                    @Override
                    public void onNext(ResultEntity resultEntity) {
                        if (resultEntity.getCode() == 200) {
                            mView.loginSuccess();//登录成功
                        }
                    }
                });
        //理论上要进行订阅取消 unSubscribe
    }
}
