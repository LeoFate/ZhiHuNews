package com.example.admin.myapplication.Presenter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.example.admin.myapplication.View.Banner

class ViewPagerAdapter(fm: FragmentManager, private val list: List<Banner>) : FragmentPagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        return list[i]
    }

    override fun getCount(): Int {
        return list.size
    }
}
