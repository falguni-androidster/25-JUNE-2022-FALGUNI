package com.example.august9task

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {

    lateinit var tasklist: ListView
    var arrayList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrayList.addAll(resources.getStringArray(R.array.task))
        tasklist = findViewById(R.id.lv_list)
        val adapter = TaskAdapter(this, arrayList)
        tasklist.adapter = adapter
    }
}