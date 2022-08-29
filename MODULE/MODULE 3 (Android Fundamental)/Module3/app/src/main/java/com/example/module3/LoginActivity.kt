package com.example.module3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {

    lateinit var edemail : EditText
    lateinit var edpwd : EditText

    lateinit var showhide : ImageView

    lateinit var btnsignin : AppCompatButton
    lateinit var btnreset : AppCompatButton

    var status = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edemail = findViewById(R.id.ed_email)
        edpwd = findViewById(R.id.ed_pwd)
        showhide = findViewById(R.id.iv_show)

        btnsignin = findViewById(R.id.btn_signin)
        btnreset = findViewById(R.id.btn_reset)

        showhide.setOnClickListener{
            if(!status){
                edpwd.transformationMethod = HideReturnsTransformationMethod.getInstance()
                edpwd.isEnabled = false
                showhide.background = resources.getDrawable(R.drawable.ic_baseline_lock_open_24)
                status = true
            } else {
                edpwd.transformationMethod = PasswordTransformationMethod.getInstance()
                edpwd.isEnabled = true
                showhide.background = resources.getDrawable(R.drawable.ic_baseline_lock_24)
                status = false
            }
        }

        btnsignin.setOnClickListener {
            if((edemail.text.isEmpty()) || (edpwd.text.isEmpty())){
                Toast.makeText(this, "Enter Details required", Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(ActivityAug6@this,LandRActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnreset.setOnClickListener {
            edemail.text.clear()
            edpwd.text.clear()
        }

    }
}