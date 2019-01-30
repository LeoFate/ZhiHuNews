package com.example.admin.myapplication.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @get:GET("latest")
    val latest: Call<InfoBean>

    @GET("before/{date}")
    fun getBefore(@Path("date") date: String): Call<InfoBean>
}
