package com.example.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton

class PassDataActivity : AppCompatActivity() {

    lateinit var edtxt : EditText
    lateinit var btnpassdata : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passdata)

        edtxt = findViewById(R.id.ed_txt)
        btnpassdata = findViewById(R.id.btn_passdata)

        btnpassdata.setOnClickListener {
            var intent = Intent(this,PassData2Activity::class.java)
            intent.putExtra("passdata",edtxt.text.toString())
            startActivity(intent)
            finish()
        }

    }
}