package com.example.admin.myapplication.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.admin.myapplication.R;

public class WebActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        /*取出传入intent的参数*/
        int id = this.getIntent().getExtras().getInt("id");
        WebView webView = (WebView) findViewById(R.id.WebView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        /*加载网页*/
        webView.loadUrl("https://daily.zhihu.com/story/" + id);
    }
}
