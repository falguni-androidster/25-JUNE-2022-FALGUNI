package com.example.module4.Que11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.module4.R

class Que11Activity : AppCompatActivity() {

    lateinit var tvminusplus : TextView
    lateinit var btnplus : AppCompatButton
    lateinit var btnminus : AppCompatButton

    private var counter = 0f
    private var size: Float = 0f


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que11)

        tvminusplus = findViewById(R.id.tv_que11)
        btnplus = findViewById(R.id.btn_que11_plus)
        btnminus = findViewById(R.id.btn_que11_minus)

        counter = pixelsToSp(tvminusplus.textSize)

        btnplus.setOnClickListener {
            changeText(true)
        }

        btnminus.setOnClickListener {
            if(counter > 0) changeText(false)
        }
    }

    private fun changeText(incement: Boolean){
        size = if(incement) ++counter
        else --counter

        tvminusplus.textSize = size
    }

    fun pixelsToSp(px: Float): Float {
        val scaledDensity = resources.displayMetrics.scaledDensity
        return px / scaledDensity
    }
}