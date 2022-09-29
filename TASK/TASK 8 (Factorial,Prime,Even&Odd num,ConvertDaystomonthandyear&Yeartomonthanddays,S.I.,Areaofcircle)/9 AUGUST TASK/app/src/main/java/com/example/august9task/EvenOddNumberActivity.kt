package com.example.august9task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.isDigitsOnly

class EvenOddNumberActivity : AppCompatActivity() {

    lateinit var ednum : EditText
    lateinit var btnevenodd : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_even_odd_number)

        ednum = findViewById(R.id.ed_evenodd)
        btnevenodd = findViewById(R.id.btn_evenodd)

        btnevenodd.setOnClickListener {
            if(ednum.text.isNotEmpty()) {
                var num = ednum.text.toString().toInt()
                if(num % 2 == 0){
                    Toast.makeText(this, "$num is Even Number", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "$num is Odd Number", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Enter a valid Number", Toast.LENGTH_SHORT).show()
            }
        }

    }
}