package com.example.admin.myapplication.Presenter

import android.util.Log
import android.widget.Toast

import com.example.admin.myapplication.Contact
import com.example.admin.myapplication.Model.InfoBean
import com.example.admin.myapplication.Model.RetrofitInstance
import com.example.admin.myapplication.MyApplication
import com.example.admin.myapplication.View.MainActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val mainActivity: MainActivity) : Contact.MainPre {

    override fun getLatestData() {
        RetrofitInstance.instance.latestCall.enqueue(object : Callback<InfoBean> {
            override fun onResponse(call: Call<InfoBean>, response: Response<InfoBean>) {
                mainActivity.initRV(response.body())
            }

            override fun onFailure(call: Call<InfoBean>, t: Throwable) {
                Log.e("Retrofit", "错误", t)
                Toast.makeText(MyApplication.context, "好像出现错误啦", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun getBeforeData(date: String) {
        RetrofitInstance.instance.getBeforeCall(date).enqueue(object : Callback<InfoBean> {
            override fun onResponse(call: Call<InfoBean>, response: Response<InfoBean>) {
                mainActivity.loadMore(response.body())
            }

            override fun onFailure(call: Call<InfoBean>, t: Throwable) {
                Log.e("Retrofit", "错误", t)
                Toast.makeText(MyApplication.context, "好像出现错误啦", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
