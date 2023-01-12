package com.example.mcdelivery.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mcdelivery.FirstScreen.FirstScreenActivity
import com.example.mcdelivery.R

class SplashActivity : AppCompatActivity() {

    lateinit var image : ImageView
    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        image = findViewById(R.id.iv_mcd)
        text = findViewById(R.id.tv_mcd)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler(Looper.getMainLooper()).postDelayed({
            image.setBackgroundDrawable(resources.getDrawable(R.drawable.app_logo))
            text.text = "From  -  Falguni"
        },1000)

        Handler(Looper.getMainLooper()).postDelayed({
            var i = Intent(this, FirstScreenActivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}