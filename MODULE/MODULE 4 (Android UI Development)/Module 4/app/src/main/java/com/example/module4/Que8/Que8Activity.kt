package com.example.module4.Que8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.module4.R

class Que8Activity : AppCompatActivity() {

    lateinit var tvshowhide : TextView
    lateinit var btnshow : AppCompatButton
    lateinit var btnhide : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que8)

        tvshowhide = findViewById(R.id.tv_que8)

        btnshow = findViewById(R.id.btn_que8_show)
        btnhide = findViewById(R.id.btn_que8_hide)

        btnshow.setOnClickListener {
            tvshowhide.visibility = View.VISIBLE
        }

        btnhide.setOnClickListener {
            tvshowhide.visibility = View.INVISIBLE
        }

    }
}