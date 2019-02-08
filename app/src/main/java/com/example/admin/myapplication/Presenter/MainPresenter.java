package com.example.admin.myapplication.Presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.admin.myapplication.Contact;
import com.example.admin.myapplication.Model.InfoBean;
import com.example.admin.myapplication.Model.RetrofitInstance;
import com.example.admin.myapplication.MyApplication;
import com.example.admin.myapplication.View.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements Contact.MainPre {
    private Contact.MainView mainView;

    public MainPresenter(Contact.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void getLatestData() {
        RetrofitInstance.getInstance().getLatestCall().enqueue(new Callback<InfoBean>() {
            @Override
            public void onResponse(Call<InfoBean> call, Response<InfoBean> response) {
                mainView.initRV(response.body());
            }

            @Override
            public void onFailure(Call<InfoBean> call, Throwable t) {
                Log.e("Retrofit", "错误", t);
                Toast.makeText(MyApplication.getContext(), "好像出现错误啦", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void getBeforeData(String date) {
        RetrofitInstance.getInstance().getBeforeCall(date).enqueue(new Callback<InfoBean>() {
            @Override
            public void onResponse(Call<InfoBean> call, Response<InfoBean> response) {
                mainView.loadMore(response.body());
            }

            @Override
            public void onFailure(Call<InfoBean> call, Throwable t) {
                Log.e("Retrofit", "错误", t);
                Toast.makeText(MyApplication.getContext(), "好像出现错误啦", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
