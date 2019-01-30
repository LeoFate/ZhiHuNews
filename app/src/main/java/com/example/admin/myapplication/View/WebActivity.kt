package com.example.admin.myapplication.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import android.webkit.WebViewClient

import com.example.admin.myapplication.R

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        /*取出传入intent的参数*/
        val id = this.intent.extras!!.getInt("id")
        val webView = findViewById<View>(R.id.WebView) as WebView
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        /*加载网页*/
        webView.loadUrl("https://daily.zhihu.com/story/$id")
    }
}
