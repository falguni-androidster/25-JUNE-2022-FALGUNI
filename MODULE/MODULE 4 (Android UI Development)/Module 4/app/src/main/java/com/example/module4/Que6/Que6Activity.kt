package com.example.module4.Que6

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.os.*
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.module4.R


class Que6Activity : AppCompatActivity() {

    lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que6)

        webView = findViewById(R.id.web_view)
        if (isOnline()) {
            startWebView("https://www.google.com/")
        } else {
            try {
                Toast.makeText(this, "No Internet connection!", Toast.LENGTH_SHORT).show()            } catch (e: Exception) {
                Log.d("tag", "Show Dialog: " + e.message)
            }
        }
    }

    private fun startWebView(url: String) {
        webView.webViewClient = object : WebViewClient() {

            var progressDialog: ProgressDialog? = null

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onLoadResource(view: WebView, url: String) {
                if (progressDialog == null) {
                    progressDialog = ProgressDialog(this@Que6Activity)
                    progressDialog!!.setMessage("Loading...")
                    progressDialog!!.show()
                }
            }

            override fun onPageFinished(view: WebView, url: String) {
                progressDialog!!.dismiss()
            }
        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)
    }

    fun isOnline(): Boolean {
        val conMgr =
            applicationContext.getSystemService(Activity.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        if (netInfo == null || !netInfo.isConnected || !netInfo.isAvailable) {
            Toast.makeText(this, "No Internet connection!", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onBackPressed() {
        if(webView.canGoForward()){
            webView.goForward()
        }else{
            super.onBackPressed()
        }
    }
}