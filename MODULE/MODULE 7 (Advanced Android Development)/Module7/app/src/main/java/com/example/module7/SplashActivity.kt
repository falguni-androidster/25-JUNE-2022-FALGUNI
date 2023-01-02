package com.example.module7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.LinearLayout

class SplashActivity : AppCompatActivity() {

    lateinit var linear : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        linear = findViewById(R.id.ll_splash)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        linear.startAnimation(slideAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            var i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}