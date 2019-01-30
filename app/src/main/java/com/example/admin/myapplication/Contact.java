package com.example.admin.myapplication;

import android.view.View;

import com.example.admin.myapplication.Model.InfoBean;

public interface Contact {
    interface BannerView {
        void initId(View view);
        void loadPic();
    }

    interface MainView {
        void initId();
        void initRV(InfoBean infoBean);
        void getData();
        void refresh();
        void loadMore(InfoBean infoBean);
    }

    interface MainPre {
        void getLatestData();
        void getBeforeData(String date);
    }
}
