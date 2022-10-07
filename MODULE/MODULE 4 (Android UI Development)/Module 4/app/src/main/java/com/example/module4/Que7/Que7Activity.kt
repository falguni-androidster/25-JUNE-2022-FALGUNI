package com.example.module4.Que7

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.module4.R

class Que7Activity : AppCompatActivity() {

    lateinit var webView : WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que7)

        webView = findViewById(R.id.webview_que7)

        if (isOnline()) {
            startWebView("https://www.google.com/")
        } else {
            try {
                val alertDialog: AlertDialog = AlertDialog.Builder(this).create()
                alertDialog.setTitle("Info")
                alertDialog.setMessage("Internet not available, Cross check your internet connectivity and try again")
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert)
                alertDialog.setButton("OK",
                    DialogInterface.OnClickListener { dialog, which -> finish() })
                alertDialog.show()
            } catch (e: Exception) {
                Log.d("tag", "Show Dialog: " + e.message)
            }
        }
    }

    fun isOnline(): Boolean {
        val conMgr =
            applicationContext.getSystemService(Activity.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = conMgr.activeNetworkInfo
        if (netInfo == null || !netInfo.isConnected || !netInfo.isAvailable) {
            /*Toast.makeText(this, "No Internet connection!", Toast.LENGTH_LONG).show()*/
            return false
        }
        return true
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
                    progressDialog = ProgressDialog(this@Que7Activity)
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

    override fun onBackPressed() {
        if(webView.canGoForward()){
            webView.goForward()
        }else{
            super.onBackPressed()
        }
    }
}