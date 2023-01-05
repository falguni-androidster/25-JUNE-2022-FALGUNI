package com.example.module3.que3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.module3.R

class NavigateScreen2Activity : AppCompatActivity() {

    lateinit var btnscreen2 : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigatescreen2)

        btnscreen2 = findViewById(R.id.btn_screen2)

        btnscreen2.setOnClickListener {
            var intent = Intent(this, NavigateScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}