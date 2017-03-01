package com.h.mvpdemo.model;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.h.mvpdemo.BuildConfig;
import com.h.mvpdemo.model.api.NetApi;
import com.h.mvpdemo.model.api.converter.FastJsonConverterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * com.h.mvpdemo.model/MvpDemo
 * 作者：Harvey on 2017/3/1 17:03
 * 邮箱：497823256@qq.com
 * 说明：
 * 修改：
 * 修改说明：
 */
public class ApiManager {


    private ApiManager() {
    }

    public static NetApi getNetApi() {
        return initWeatherService(NetApi.URL, NetApi.class);
    }

    private static <T> T initWeatherService(String baseUrl, Class<T> clazz) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor).addNetworkInterceptor(new StethoInterceptor());
        }
        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();

        return retrofit.create(clazz);
    }
}
