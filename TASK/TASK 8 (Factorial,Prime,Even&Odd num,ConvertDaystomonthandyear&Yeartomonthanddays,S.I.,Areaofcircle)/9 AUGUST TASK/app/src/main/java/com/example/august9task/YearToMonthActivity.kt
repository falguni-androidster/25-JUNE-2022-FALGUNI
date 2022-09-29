package com.example.august9task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.isDigitsOnly

class YearToMonthActivity : AppCompatActivity() {

    lateinit var edyear : EditText
    lateinit var btnconvert : AppCompatButton
    lateinit var tvmonth : TextView
    lateinit var tvdays : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_year_to_month)

        edyear = findViewById(R.id.ed_year)
        btnconvert = findViewById(R.id.btn_convert)
        tvmonth = findViewById(R.id.tv_display_month)
        tvdays = findViewById(R.id.tv_display_days)

        btnconvert.setOnClickListener {
            if(edyear.text.isNotEmpty()) {
                var year = edyear.text.toString().toInt()
                var month = (year % 365) * 12
                var days = year * 365
                tvmonth.text = "Month = $month"
                tvdays.text = "Days = $days"
            }else{
                tvmonth.text = ""
                tvdays.text = ""
                Toast.makeText(this, "Enter a valid Year", Toast.LENGTH_SHORT).show()
            }
        }
    }
}