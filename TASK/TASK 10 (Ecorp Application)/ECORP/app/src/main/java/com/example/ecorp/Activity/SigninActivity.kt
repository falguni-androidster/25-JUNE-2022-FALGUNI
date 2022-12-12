package com.example.ecorp.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.ecorp.R
import com.google.android.material.textfield.TextInputEditText


class SigninActivity : AppCompatActivity() {

    lateinit var edemail : TextInputEditText
    lateinit var edpwd : TextInputEditText
    lateinit var btnsignin : AppCompatButton
    lateinit var tvsignup : TextView

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        edemail = findViewById(R.id.ed_email)
        edpwd = findViewById(R.id.ed_pwd)
        btnsignin = findViewById(R.id.btn_signin)
        tvsignup = findViewById(R.id.tv_signup)

        myshared = this.getSharedPreferences("ecorppref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        if (myshared.getBoolean("status",false)){
            var intent = Intent(this, DashboardActivity :: class.java)
            finish()
            startActivity(intent)
        }

        btnsignin.setOnClickListener {
            if(edemail.text.toString()!= "" && edpwd.text.toString()!= ""){
                var email = myshared.getString("email","default")
                var password = myshared.getString("password","default")
                if (email.equals(edemail.text.toString()) && password.equals(edpwd.text.toString())){
                    editor.putBoolean("status",true)
                    editor.apply()
                    editor.commit()

                    var intent = Intent(this, DashboardActivity :: class.java)
                    finish()
                    startActivity(intent)
                }
            }else{
                Toast.makeText(this@SigninActivity, "Please Enter All Field", Toast.LENGTH_SHORT).show()
            }
        }

        tvsignup.setOnClickListener {
            var intent = Intent(this@SigninActivity, SignupActivity :: class.java)
            finish()
            startActivity(intent)
        }
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}