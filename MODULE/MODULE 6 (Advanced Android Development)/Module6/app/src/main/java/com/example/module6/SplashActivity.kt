package com.example.module6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    lateinit var backgroundimage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        backgroundimage = findViewById(R.id.iv_splash)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        backgroundimage.startAnimation(slideAnimation)

        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this,MainActivity :: class.java)
            finish()
            startActivity(intent)
        },3000)

    }
}