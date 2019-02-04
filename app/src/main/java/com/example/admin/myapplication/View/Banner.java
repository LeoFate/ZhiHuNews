package com.example.admin.myapplication.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.admin.myapplication.Contact;
import com.example.admin.myapplication.MyApplication;
import com.example.admin.myapplication.R;

public class Banner extends Fragment implements Contact.BannerView {

    public int getThisId() {
        return getArguments().getInt("id");
    }

    private ImageView imageView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_image, container, false);
        initId(view);
        loadPic();
        view.setOnClickListener(v->{
            Intent intent = new Intent(MyApplication.getContext(), WebActivity.class);
            intent.putExtra("id", getThisId());
            MyApplication.getContext().startActivity(intent);
        });
        return view;
    }

    public static Banner getBannerInstance(Bundle arg) {
        Banner banner = new Banner();
        banner.setArguments(arg);
        return banner;
    }

    @Override
    public void initId(View view) {
        imageView = view.findViewById(R.id.top_image_view);
    }

    @Override
    public void loadPic() {
        Glide.with(MyApplication.getContext())
                .load(getArguments().getString("image"))
                .into(imageView);
    }
}
