package com.example.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class NavigateScreenActivity : AppCompatActivity() {

    lateinit var btnscreen1 : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigatescreen)

        btnscreen1 = findViewById(R.id.btn_screen1)

        btnscreen1.setOnClickListener {
            var intent = Intent(this,NavigateScreen2Activity::class.java)
            startActivity(intent)
            finish()
        }

    }
}