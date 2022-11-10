package com.example.module5

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class RegistrationActivity : AppCompatActivity() {

    lateinit var edusername : EditText
    lateinit var edemail : EditText
    lateinit var edpassword : EditText

    lateinit var btnregistration : AppCompatButton

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    lateinit var tv_loginlink : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        edusername = findViewById(R.id.ed_username)
        edemail = findViewById(R.id.ed_email)
        edpassword = findViewById(R.id.ed_password)

        btnregistration = findViewById(R.id.btn_registration)

        tv_loginlink = findViewById(R.id.tv_loginlink)
        tv_loginlink.setOnClickListener {
            var intent = Intent(this,LoginActivity :: class.java)
            finish()
            startActivity(intent)
        }

        myshared = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        btnregistration.setOnClickListener {
            editor.putString("username",edusername.text.toString())
            editor.putString("email",edemail.text.toString())
            editor.putString("password",edpassword.text.toString())

            editor.apply()
            editor.commit() // shared preference save

            var intent = Intent(this,LoginActivity :: class.java)
            finish()
            startActivity(intent)
        }

    }
}