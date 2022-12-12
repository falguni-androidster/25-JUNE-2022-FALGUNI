package com.example.module6.Que6

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.module6.R


class FrameAnimActivity : AppCompatActivity() {

    lateinit var imageanim : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frameanim)

        imageanim = findViewById(R.id.iv_frameanim)
        onStartAnimation()
    }

    private fun onStartAnimation() {
        val valueAnimator = ValueAnimator.ofFloat(0f, -1500f)
        valueAnimator.addUpdateListener {
            val value = it.animatedValue as Float
            imageanim.translationY = value
        }
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = 8000L
        valueAnimator.start()
    }
}