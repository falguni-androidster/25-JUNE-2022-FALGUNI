package com.example.module5

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var edemail = findViewById<EditText>(R.id.ed_email_login)
        var edpwd = findViewById<EditText>(R.id.ed_pwd_login)

        var btnsignin = findViewById<AppCompatButton>(R.id.btn_signin)
        var btnreset = findViewById<AppCompatButton>(R.id.btn_reset)

        var registrationlink = findViewById<TextView>(R.id.tv_registrationlink)
        registrationlink.setOnClickListener {
            var intent = Intent(this,RegistrationActivity :: class.java)
            finish()
            startActivity(intent)
        }

        myshared = this.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        if (myshared.getBoolean("status",false)){
            // Direct call dashboard activity
            var intent = Intent(this,MainActivity :: class.java)
            finish()
            startActivity(intent)
        }

        btnsignin.setOnClickListener {
            var email = myshared.getString("email","default")
            var password = myshared.getString("password","default")
            if (email.equals(edemail.text.toString()) && password.equals(edpwd.text.toString())){
                editor.putBoolean("status",true)
                editor.apply()
                editor.commit()
                var intent = Intent(this,MainActivity :: class.java)
                finish()
                startActivity(intent)
            }else{
                Toast.makeText(this@LoginActivity, "Invalid data", Toast.LENGTH_SHORT).show()
            }
        }

        btnreset.setOnClickListener {
            edemail.text.clear()
            edpwd.text.clear()
        }
    }
}