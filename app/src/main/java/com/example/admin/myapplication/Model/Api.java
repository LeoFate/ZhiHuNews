package com.example.admin.myapplication.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    @GET("latest")
    Call<InfoBean> getLatest();

    @GET("before/{date}")
    Call<InfoBean> getBefore(@Path("date") String date);
}
