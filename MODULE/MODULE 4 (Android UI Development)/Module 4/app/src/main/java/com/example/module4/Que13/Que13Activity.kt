package com.example.module4.Que13

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.example.module4.R

class Que13Activity : AppCompatActivity() {

    lateinit var checkbox : CheckBox
    lateinit var tvshowhide : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que13)

        checkbox = findViewById(R.id.cb_que13)
        tvshowhide = findViewById(R.id.tv_que13)

        checkbox.setOnClickListener {
            if (checkbox.isChecked){
                tvshowhide.visibility = View.VISIBLE
            }else{
                tvshowhide.visibility = View.INVISIBLE
            }
        }
    }
}