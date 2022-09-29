package com.example.august9task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.isDigitsOnly

class DaysToMonthActivity : AppCompatActivity() {

    lateinit var eddays : EditText
    lateinit var btnconvert : AppCompatButton
    lateinit var tvmonthandyear : TextView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_days_to_month)

        eddays = findViewById(R.id.ed_days)
        btnconvert = findViewById(R.id.btn_convert_days)
        tvmonthandyear = findViewById(R.id.tv_display_year)

        btnconvert.setOnClickListener {
            if(eddays.text.isNotEmpty()) {
                var days = eddays.text.toString().toInt()
                var month = (days % 365) / 30
                var year = days / 365
                tvmonthandyear.text = "Month = $month & Year = $year"
            }else{
                tvmonthandyear.text = ""
                Toast.makeText(this, "Enter a valid Days", Toast.LENGTH_SHORT).show()
            }
        }
    }
}