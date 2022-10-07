package com.example.module4.Que5

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.module4.R


class Que5Activity : AppCompatActivity() {

    lateinit var webView : WebView
    lateinit var ivback : ImageView
    lateinit var ivforward : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que5)

        webView = findViewById(R.id.webview_que5)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.google.com/")

        ivback = findViewById(R.id.iv_back)
        ivforward = findViewById(R.id.iv_forward)

        ivback.setOnClickListener {
            if(webView.canGoBack()){
                webView.goBack()
            }
        }

        ivforward.setOnClickListener {
            if(webView.canGoForward()){
                webView.goForward()
            }
        }
    }
}