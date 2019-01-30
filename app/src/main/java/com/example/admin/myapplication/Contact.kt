package com.example.admin.myapplication

import android.view.View

import com.example.admin.myapplication.Model.InfoBean

interface Contact {
    interface BannerView {
        fun initId(view: View)
        fun loadPic()
    }

    interface MainView {
        fun initId()
        fun initRV(infoBean: InfoBean)
        fun getData()
        fun refresh()
        fun loadMore(infoBean: InfoBean)
    }

    interface MainPre {
        fun getLatestData()
        fun getBeforeData(date: String)
    }
}
