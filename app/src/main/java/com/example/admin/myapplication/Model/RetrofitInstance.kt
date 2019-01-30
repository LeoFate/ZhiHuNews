package com.example.admin.myapplication.Model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance private constructor() {
    private val api: Api

    val latestCall: Call<InfoBean>
        get() = api.latest

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        api = retrofit.create(Api::class.java!!)
    }

    fun getBeforeCall(date: String): Call<InfoBean> {
        return api.getBefore(date)
    }

    companion object {
        private val BASE_URL = "https://news-at.zhihu.com/api/3/news/"
        private var retrofitInstance: RetrofitInstance? = null

        val instance: RetrofitInstance
            get() {
                if (retrofitInstance == null) {
                    synchronized(RetrofitInstance::class.java) {
                        if (retrofitInstance == null) {
                            retrofitInstance = RetrofitInstance()
                        }
                    }
                }
                return retrofitInstance
            }
    }
}
