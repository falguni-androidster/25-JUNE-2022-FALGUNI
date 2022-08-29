package com.example.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class RegistrationActivity : AppCompatActivity() {

    lateinit var edfname : EditText
    lateinit var edlname : EditText
    lateinit var eduname : EditText
    lateinit var edemail : EditText
    lateinit var edpwd : EditText

    lateinit var btnregister : AppCompatButton
    lateinit var btncancel : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        edfname = findViewById(R.id.ed_firstname)
        edlname = findViewById(R.id.ed_lastname)
        eduname = findViewById(R.id.ed_username)
        edemail = findViewById(R.id.ed_emailname)
        edpwd = findViewById(R.id.ed_pwdname)

        btnregister = findViewById(R.id.btn_register)
        btncancel = findViewById(R.id.btn_cancel)

        btnregister.setOnClickListener {
            if(edfname.text.isEmpty() || edlname.text.isEmpty() || eduname.text.isEmpty() || edemail.text.isEmpty() || edpwd.text.isEmpty()){
                Toast.makeText(this, "Enter Details required", Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(ActivityAug6@this,LandRActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btncancel.setOnClickListener {
            var intent = Intent(ActivityAug6@this,LandRActivity::class.java)
            startActivity(intent)
            finish()
        }







    }
}