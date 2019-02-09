package com.example.admin.myapplication.Presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.myapplication.Contact;
import com.example.admin.myapplication.View.Banner;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter implements Contact.ViewPagerAdapter {
    private List<Banner> list = new ArrayList<>();

    ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    public void inflateData(List<Banner> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
}
