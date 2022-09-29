package com.example.august9task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.isDigitsOnly

class FactorialActivity : AppCompatActivity() {

    lateinit var ednumber : EditText
    lateinit var btnfactorial : AppCompatButton
    lateinit var tvdisplay : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factorial)

        ednumber = findViewById(R.id.ed_fact_num)
        btnfactorial = findViewById(R.id.btn_factorial)
        tvdisplay = findViewById(R.id.tv_display)

        btnfactorial.setOnClickListener {
            if(ednumber.text.isNotEmpty()) {
                var factorial = 1
                for (i in 1..ednumber.text.toString().toInt()) {
                    factorial *= i
                }
                tvdisplay.text = factorial.toString()
            }else{
                tvdisplay.text = ""
                Toast.makeText(this, "Enter a valid Number", Toast.LENGTH_SHORT).show()
            }

        }
    }
}