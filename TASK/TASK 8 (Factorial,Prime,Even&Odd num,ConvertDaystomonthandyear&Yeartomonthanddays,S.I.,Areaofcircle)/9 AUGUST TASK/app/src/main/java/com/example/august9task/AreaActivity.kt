package com.example.august9task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.isDigitsOnly

class AreaActivity : AppCompatActivity() {

    lateinit var edradious : EditText
    lateinit var btnarea : AppCompatButton
    lateinit var tvarea : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area)

        edradious = findViewById(R.id.ed_area)
        btnarea = findViewById(R.id.btn_area)
        tvarea = findViewById(R.id.tv_display_area)

        btnarea.setOnClickListener {
            if(edradious.text.isNotEmpty()) {
                var pi = 3.14
                var radious = edradious.text.toString().toFloat()
                var area = pi * radious * radious
                tvarea.text = area.toString()
            }else{
                tvarea.text = ""
                Toast.makeText(this, "Enter a valid Radious", Toast.LENGTH_SHORT).show()
            }
        }
    }
}