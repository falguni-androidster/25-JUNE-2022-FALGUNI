package com.example.module6.Que3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.example.module6.R

class RotateBlinkImageActivity : AppCompatActivity() {

    lateinit var btnrotate : AppCompatButton
    lateinit var btnblink : AppCompatButton
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotateblink_image)

        image = findViewById(R.id.iv_que5)
        btnrotate = findViewById(R.id.btn_rotate)
        btnblink = findViewById(R.id.btn_blink)

        btnrotate.setOnClickListener {
            var rotateanim = AnimationUtils.loadAnimation(this@RotateBlinkImageActivity,R.anim.rotateanimation)
            image.startAnimation(rotateanim)
        }

        btnblink.setOnClickListener {
            var blinkanim = AnimationUtils.loadAnimation(this@RotateBlinkImageActivity,R.anim.blinkanimation)
            image.startAnimation(blinkanim)
        }
    }
}