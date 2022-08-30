package com.example.module3

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    lateinit var btnhello : AppCompatButton
    lateinit var btnchangebg : AppCompatButton
    lateinit var btnnavigatesceen : AppCompatButton
    lateinit var btnpassdata : AppCompatButton
    lateinit var btnlogin : AppCompatButton
    lateinit var btnrjava : AppCompatButton
    lateinit var btnlifecycleactivity : AppCompatButton
    lateinit var btnlifecyclefragment : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnhello = findViewById(R.id.btn_1)
        btnchangebg = findViewById(R.id.btn_2)
        btnnavigatesceen = findViewById(R.id.btn_3)
        btnpassdata = findViewById(R.id.btn_4)
        btnlogin = findViewById(R.id.btn_5)
        btnrjava = findViewById(R.id.btn_6)
        btnlifecycleactivity = findViewById(R.id.btn_7)
        btnlifecyclefragment = findViewById(R.id.btn_8)

        btnhello.setOnClickListener {
            var intent = Intent(MainActivity@this,HelloActivity::class.java)
            startActivity(intent)
        }

        btnchangebg.setOnClickListener {
            var intent = Intent(MainActivity@this,ChangeBackgroundActivity::class.java)
            startActivity(intent)
        }

        btnnavigatesceen.setOnClickListener {
            var intent = Intent(MainActivity@this,NavigateScreenActivity::class.java)
            startActivity(intent)
        }

        btnpassdata.setOnClickListener {
            var intent = Intent(MainActivity@this,PassDataActivity::class.java)
            startActivity(intent)
        }

        btnlogin.setOnClickListener {
            var intent = Intent(MainActivity@this,LandRActivity::class.java)
            startActivity(intent)
        }

        btnrjava.setOnClickListener {
            var intent = Intent(MainActivity@this,RJavaActivity::class.java)
            startActivity(intent)
        }

        btnlifecycleactivity.setOnClickListener {
            var intent = Intent(MainActivity@this,LifecycleActivity::class.java)
            startActivity(intent)
        }

        btnlifecyclefragment.setOnClickListener {
            var intent = Intent(MainActivity@this,FragmentLifecycleActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Do you want close this app?")
            .setCancelable(false)
            .setPositiveButton("Exit", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
                finish()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }
}