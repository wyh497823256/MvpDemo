package com.h.mvpdemo.logic.main;

import com.h.mvpdemo.entity.ResultEntity;

import rx.Observable;

/**
 * com.h.mvpdemo.logic.main/MvpDemo
 * 作者：Harvey on 2017/3/1 10:44
 * 邮箱：497823256@qq.com
 * 说明：
 * 修改：
 * 修改说明：
 */
public interface MainContract {

    interface View {

        void loginSuccess();//登录成功，UI做出响应

        String getUserName();//获取用户名

        String getPassWord();//获取密码

        void showMessage(String message);
    }

    interface Model {
        /**
         * @param name     用户名
         * @param password 密码
         * @return
         */
        Observable<ResultEntity> login(String name, String password);//请求服务器登录
    }

    interface Presenter {
        void login(); //登录
    }

}
