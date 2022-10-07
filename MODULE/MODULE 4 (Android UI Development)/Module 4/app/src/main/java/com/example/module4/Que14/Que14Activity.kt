package com.example.module4.Que14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.module4.R

class Que14Activity : AppCompatActivity() {

    lateinit var lv : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que14)

        lv = findViewById(R.id.lv_list)
        lv.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, ""+lv.getItemAtPosition(i), Toast.LENGTH_SHORT).show()
        }
    }
}