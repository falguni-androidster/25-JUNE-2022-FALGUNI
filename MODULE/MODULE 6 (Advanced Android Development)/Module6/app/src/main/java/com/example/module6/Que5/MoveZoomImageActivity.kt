package com.example.module6.Que5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import com.example.module6.R

class MoveZoomImageActivity : AppCompatActivity() {

    lateinit var btnmove : AppCompatButton
    lateinit var btnzoominout : AppCompatButton
    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movezoom_image)

        image = findViewById(R.id.iv_que6)
        btnmove = findViewById(R.id.btn_move)
        btnzoominout = findViewById(R.id.btn_zoom)

        btnmove.setOnClickListener {
            var rotateanim = AnimationUtils.loadAnimation(this@MoveZoomImageActivity,R.anim.moveanimation)
            image.startAnimation(rotateanim)
        }

        btnzoominout.setOnClickListener {
            var blinkanim = AnimationUtils.loadAnimation(this@MoveZoomImageActivity,R.anim.zoominoutanimation)
            image.startAnimation(blinkanim)
        }

    }
}