package com.example.admin.myapplication.Model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BASE_URL = "https://news-at.zhihu.com/api/3/news/";
    private static RetrofitInstance retrofitInstance;
    private Api api;

    private RetrofitInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        api = retrofit.create(Api.class);
    }

    public static RetrofitInstance getInstance() {
        if (retrofitInstance == null) {
            synchronized (RetrofitInstance.class) {
                if (retrofitInstance == null) {
                    retrofitInstance = new RetrofitInstance();
                }
            }
        }
        return retrofitInstance;
    }

    public Call<InfoBean> getLatestCall() {
        return api.getLatest();
    }

    public Call<InfoBean> getBeforeCall(String date) {
        return api.getBefore(date);
    }
}
