package com.example.module3.que2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatButton
import com.example.module3.R

class ChangeBackgroundActivity : AppCompatActivity() {

    lateinit var linearcolor : LinearLayout
    lateinit var btnpink : AppCompatButton
    lateinit var btnorange : AppCompatButton
    lateinit var btnyellow : AppCompatButton
    lateinit var btngreen : AppCompatButton

    var status = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changebackground)

        linearcolor = findViewById(R.id.linear_color)
        btnpink = findViewById(R.id.btn_pink)
        btnorange = findViewById(R.id.btn_orange)
        btnyellow = findViewById(R.id.btn_yellow)
        btngreen = findViewById(R.id.btn_green)

        btnpink.setOnClickListener {
            if (!status) {
                linearcolor.setBackgroundColor(resources.getColor(R.color.pink))
                status = true
            } else {
                linearcolor.setBackgroundColor(resources.getColor(R.color.white))
                status = false
            }
        }

        btnorange.setOnClickListener {
            if (!status) {
                linearcolor.setBackgroundColor(resources.getColor(R.color.orange))
                status = true
            } else {
                linearcolor.setBackgroundColor(resources.getColor(R.color.white))
                status = false
            }
        }

        btnyellow.setOnClickListener {
            if (!status) {
                linearcolor.setBackgroundColor(resources.getColor(R.color.yellow))
                status = true
            } else {
                linearcolor.setBackgroundColor(resources.getColor(R.color.white))
                status = false
            }
        }

        btngreen.setOnClickListener {
            if (!status) {
                linearcolor.setBackgroundColor(resources.getColor(R.color.green))
                status = true
            } else {
                linearcolor.setBackgroundColor(resources.getColor(R.color.white))
                status = false
            }
        }


    }
}