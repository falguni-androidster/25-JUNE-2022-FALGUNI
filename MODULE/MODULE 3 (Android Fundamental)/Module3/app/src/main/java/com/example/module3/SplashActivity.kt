package com.example.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.LinearInterpolator
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        image = findViewById(R.id.iv_app)
        image.animate().rotationBy(360f).setDuration(1000)
            .setInterpolator(LinearInterpolator()).start()

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler(Looper.getMainLooper()).postDelayed({
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },1000)

    }
}