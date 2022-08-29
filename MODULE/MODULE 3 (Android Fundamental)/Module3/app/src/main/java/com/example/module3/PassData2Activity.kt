package com.example.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class PassData2Activity : AppCompatActivity() {

    lateinit var tvdisplay : TextView
    lateinit var btnbackscreen : AppCompatButton

    lateinit var getdata : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passdata2)

        tvdisplay = findViewById(R.id.tv_display)
        btnbackscreen = findViewById(R.id.btn_passdata2)

        getdata = intent.getStringExtra("passdata")!!
        tvdisplay.text = getdata

        btnbackscreen.setOnClickListener {
            var intent = Intent(this,PassDataActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}