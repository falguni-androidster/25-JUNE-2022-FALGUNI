package com.example.module4.Que15

import android.annotation.SuppressLint
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.module4.R

class Que15Activity : AppCompatActivity() {

    lateinit var rglist : RadioGroup

    lateinit var linear : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que15)

        linear = findViewById(R.id.ll_que15)

        rglist = findViewById(R.id.rg_list)
        rglist.setOnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.rb_red){
               linear.setBackgroundResource(R.color.red)
            }else if (i == R.id.rb_blue){
                linear.setBackgroundResource(R.color.blue)
            }else if (i == R.id.rb_green){
                linear.setBackgroundResource(R.color.green)
            }else if (i == R.id.rb_yellow){
                linear.setBackgroundResource(R.color.yellow)
            }
        }
    }
}