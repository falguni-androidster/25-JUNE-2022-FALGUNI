package com.example.module4.Que4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.module4.R


class Que4Activity : AppCompatActivity() {

    lateinit var btnlogin : AppCompatButton
    lateinit var btnregistration : AppCompatButton

    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que4)

        btnlogin = findViewById(R.id.btn_que4_login)
        btnregistration = findViewById(R.id.btn_que4_registration)

        btnlogin.setOnClickListener {
            btnlogin.visibility = View.INVISIBLE
            btnregistration.visibility = View.INVISIBLE
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, LoginFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        btnregistration.setOnClickListener {
            btnlogin.visibility = View.INVISIBLE
            btnregistration.visibility = View.INVISIBLE
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.frameLayout, RegistrationFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

    }

    override fun onBackPressed() {
        btnlogin.visibility = View.VISIBLE
        btnregistration.visibility = View.VISIBLE
        super.onBackPressed()
    }
}
