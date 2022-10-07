package com.example.module4.Que17

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.example.module4.R


class Que17Activity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var spinnerAdapter: SpinnerAdapter
    lateinit var spinner : Spinner
    lateinit var image : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que17)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        var arraylist = ArrayList<String>()
        arraylist.add("Apple")
        arraylist.add("Banana")
        arraylist.add("Pineapple")
        arraylist.add("Orange")
        arraylist.add("Lychee")
        arraylist.add("Gavava")
        arraylist.add("Peech")
        arraylist.add("Melon")
        arraylist.add("Watermelon")
        arraylist.add("Papaya")

        spinner = findViewById(R.id.sp_que17)
        spinnerAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arraylist)
        spinner.adapter = spinnerAdapter

        image = findViewById(R.id.sv_que17)
        image.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                (spinnerAdapter as ArrayAdapter<String>).getFilter().filter(query)
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                (spinnerAdapter as ArrayAdapter<String>).getFilter().filter(newText)
                return false
            }
        })
    }
}