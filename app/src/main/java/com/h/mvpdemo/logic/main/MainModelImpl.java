package com.h.mvpdemo.logic.main;

import com.h.mvpdemo.entity.ResultEntity;
import com.h.mvpdemo.model.ApiManager;

import rx.Observable;

/**
 * com.h.mvpdemo.logic.main/MvpDemo
 * 作者：Harvey on 2017/3/1 17:17
 * 邮箱：497823256@qq.com
 * 说明：
 * 修改：
 * 修改说明：
 */
public class MainModelImpl implements MainContract.Model {

    @Override
    public Observable<ResultEntity> login(String name, String password) {
        return ApiManager.getNetApi().login(name, password);
    }
}
