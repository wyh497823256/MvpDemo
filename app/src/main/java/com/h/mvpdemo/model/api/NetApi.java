package com.h.mvpdemo.model.api;

import com.h.mvpdemo.entity.ResultEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * com.h.mvpdemo.model.api/MvpDemo
 * 作者：Harvey on 2017/3/1 10:45
 * 邮箱：497823256@qq.com
 * 说明：
 * 修改：
 * 修改说明：
 */
public interface NetApi {

    String URL = "http://test.api";


    @POST("user/login")
    @FormUrlEncoded
    Observable<ResultEntity> login(@Field("name") String name, @Field("password") String password);

}
