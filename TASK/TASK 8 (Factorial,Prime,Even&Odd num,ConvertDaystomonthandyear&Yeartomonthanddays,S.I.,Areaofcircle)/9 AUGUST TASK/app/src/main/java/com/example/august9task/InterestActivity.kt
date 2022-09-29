package com.example.august9task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class InterestActivity : AppCompatActivity() {

    lateinit var edamount : EditText
    lateinit var edrate : EditText
    lateinit var edtime : EditText
    lateinit var btninterest : AppCompatButton
    lateinit var tvinterest : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interest)

        edamount = findViewById(R.id.ed_amount)
        edrate = findViewById(R.id.ed_rate)
        edtime = findViewById(R.id.ed_time)
        btninterest = findViewById(R.id.btn_simple_interest)
        tvinterest = findViewById(R.id.tv_display_interest)

        btninterest.setOnClickListener {
            if(edamount.text.isNotEmpty() || edrate.text.isNotEmpty() || edtime.text.isNotEmpty()) {
                var amount = edamount.text.toString().toInt()
                var rate = edrate.text.toString().toInt()
                var time = edtime.text.toString().toInt()
                var interest = ( amount * rate * time ) / 100
                tvinterest.text = interest.toString()
            }else{
                tvinterest.text = ""
                Toast.makeText(this, "Enter a valid Radious", Toast.LENGTH_SHORT).show()
            }
        }

    }
}