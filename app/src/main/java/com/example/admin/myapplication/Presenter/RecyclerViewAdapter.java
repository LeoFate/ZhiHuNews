package com.example.admin.myapplication.Presenter;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.Model.InfoBean;
import com.example.admin.myapplication.MyApplication;
import com.example.admin.myapplication.R;
import com.example.admin.myapplication.View.Banner;
import com.example.admin.myapplication.View.MainActivity;
import com.example.admin.myapplication.View.WebActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private final int BANNER_TYPE = 1;
    private final int DATE_TYPE = 2;
    private final int MAIN_TYPE = 3;
    private List<Object> mainList = new ArrayList<>();
    private List<InfoBean.TopStoriesBean> topList = new ArrayList<>();
    private List<Banner> bannerList = new ArrayList<>();
    private Queue<String> dateList = new LinkedList<>();
    private ViewPagerAdapter viewPagerAdapter;

    public RecyclerViewAdapter(@NonNull InfoBean infoBean) {
        mainList.add("今日热闻");
        mainList.addAll(infoBean.getStories());
        dateList.add(infoBean.getDate());
        topList.addAll(infoBean.getTop_stories());
        for (int i = 0; i < topList.size(); i++) {
            bannerList.add(Banner.getBannerInstance(topList.get(i).getImage()));
        }
    }

    public void update(InfoBean infoBean) {//用来呼应下拉加载，达到在同一个对象中更新数据目的
        mainList.add(infoBean.getDate());
        mainList.addAll(infoBean.getStories());
        dateList.add(infoBean.getDate());
        notifyDataSetChanged();
    }

    public String getDate() {
        return dateList.element();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return BANNER_TYPE;
        else if (mainList.get(position - 1) instanceof String) return DATE_TYPE;
        else return MAIN_TYPE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case BANNER_TYPE:
                viewHolder = new BannerHolder(
                        LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.rv_banner, viewGroup, false)
                );
                break;
            case MAIN_TYPE:
                viewHolder = new MainHolder(
                        LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.rv_main, viewGroup, false)
                );
                break;
            case DATE_TYPE:
                viewHolder = new DateHolder(
                        LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.rv_date, viewGroup, false)
                );
                break;
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case BANNER_TYPE:
                BannerHolder bannerHolder = (BannerHolder) viewHolder;
                bannerHolder.viewPager.setAdapter(new ViewPagerAdapter(new MainActivity().getSupportFragmentManager(), bannerList));
                bannerHolder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(MyApplication.getContext(), WebActivity.class);
                    intent.putExtra("id", topList.get(i).getId());
                    MyApplication.getContext().startActivity(intent);
                });
                break;
            case MAIN_TYPE:
                MainHolder mainHolder = (MainHolder) viewHolder;
                InfoBean.StoriesBean storyBean = (InfoBean.StoriesBean) mainList.get(i - 1);
                mainHolder.title.setText(storyBean.getTitle());
                Glide.with(MyApplication.getContext())
                        .load(storyBean.getImages().get(0))
                        .into(mainHolder.image);
                mainHolder.itemView.setOnClickListener(v -> {
                    Intent intent = new Intent(MyApplication.getContext(), WebActivity.class);
                    intent.putExtra("id", storyBean.getId());
                    MyApplication.getContext().startActivity(intent);
                });
                break;
            case DATE_TYPE:
                DateHolder dateHolder = (DateHolder) viewHolder;
                dateHolder.date.setText((String) mainList.get(i - 1));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mainList.size() + 1;
    }

    class BannerHolder extends RecyclerView.ViewHolder {
        ViewPager viewPager;

        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.ViewPager);
        }
    }

    class DateHolder extends RecyclerView.ViewHolder {
        TextView date;

        public DateHolder(@NonNull View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.rv_date_text);
        }
    }

    class MainHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public MainHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.rv_main_text);
            image = (ImageView) itemView.findViewById(R.id.rv_main_image);
        }
    }
}
