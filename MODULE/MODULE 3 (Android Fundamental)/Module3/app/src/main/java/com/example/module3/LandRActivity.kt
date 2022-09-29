package com.example.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class LandRActivity : AppCompatActivity() {

    lateinit var btnlogin : AppCompatButton
    lateinit var btnregistration : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landr)

        btnlogin = findViewById(R.id.btn_loginscreen)
        btnregistration = findViewById(R.id.btn_regscreen)

        btnlogin.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnregistration.setOnClickListener {
            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}