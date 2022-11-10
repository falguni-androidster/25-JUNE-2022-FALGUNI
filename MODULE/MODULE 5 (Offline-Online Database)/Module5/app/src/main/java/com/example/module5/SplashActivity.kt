package com.example.module5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        myshared = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        Handler(Looper.getMainLooper()).postDelayed({
            if (myshared.getBoolean("status",false)){
                // Direct call dashboard activity
                var intent = Intent(this,MainActivity :: class.java)
                finish()
                startActivity(intent)
            }else{
                var intent = Intent(this,RegistrationActivity :: class.java)
                finish()
                startActivity(intent)
            }
        },1000)
    }
}