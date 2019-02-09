package com.example.admin.myapplication;

import android.view.View;

import com.example.admin.myapplication.Model.InfoBean;
import com.example.admin.myapplication.View.Banner;

import java.util.List;

public interface Contact {
    interface BannerView {
        void initId(View view);//在onCreateView里面初始化id
        void loadPic();//加载图片
    }

    interface MainView {
        void initId();//初始化除RV外控件
        void initRV(InfoBean infoBean);//初始化RV
        void getData();//获取数据
        void refresh();//刷新RV
        void loadMore(InfoBean infoBean);
    }

    interface MainPre {
        void getLatestData();
        void getBeforeData(String date);
    }

    interface RecyclerViewAdapter {
        Boolean isThereFooter();
        void changeBoolean();//监听，当滑到底部时改变布尔值来添加footer
        void update(InfoBean infoBean);//添加数据
        String getDate();//获取最后一次获取数据中date值
        void inflateData(InfoBean infoBean);
        void refresh();
    }
    interface ViewPagerAdapter{
        void inflateData(List<Banner> list);
    }
}
