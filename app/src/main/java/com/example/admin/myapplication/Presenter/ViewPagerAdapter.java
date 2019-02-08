package com.example.admin.myapplication.Presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.myapplication.View.Banner;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Banner> list;

    public ViewPagerAdapter(FragmentManager fm, List<Banner> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
