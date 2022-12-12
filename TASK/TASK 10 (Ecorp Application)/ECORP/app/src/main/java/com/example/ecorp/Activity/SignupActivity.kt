package com.example.ecorp.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.ecorp.Database.EcorpDatabase
import com.example.ecorp.Model.ModelClass
import com.example.ecorp.R
import com.google.android.material.textfield.TextInputEditText

class SignupActivity : AppCompatActivity() {

    lateinit var edfirstname : TextInputEditText
    lateinit var edlastname : TextInputEditText
    lateinit var edemail : TextInputEditText
    lateinit var edpwd : TextInputEditText
    lateinit var edcpwd : TextInputEditText
    lateinit var btnsignup : AppCompatButton

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        edfirstname = findViewById(R.id.ed_signup_firstname)
        edlastname = findViewById(R.id.ed_signup_lastname)
        edemail = findViewById(R.id.ed_signup_email)
        edpwd = findViewById(R.id.ed_signup_pwd)
        edcpwd = findViewById(R.id.ed_signup_cpwd)

        var ecorpDatabase = EcorpDatabase(this)

        myshared = this.getSharedPreferences("ecorppref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        btnsignup = findViewById(R.id.btn_signup)
        btnsignup.setOnClickListener {
            if (edfirstname.text.toString() != "" && edlastname.text.toString() != "" && edemail.text.toString() != "" && edpwd.text.toString()!= ""){
                if (edpwd.text.toString() == edcpwd.text.toString()){
                    var insertID = ecorpDatabase.insert(ModelClass(it.id!!,edfirstname.text.toString(),edlastname.text.toString(),edemail.text.toString(),edpwd.text.toString()))
                    if (insertID > 1){
                        editor.putString("firstname",edfirstname.text.toString())
                        editor.putString("lastname",edlastname.text.toString())
                        editor.putString("email",edemail.text.toString())
                        editor.putString("password",edpwd.text.toString())
                        editor.apply()
                        editor.commit()
                        Toast.makeText(this, "Successfully Data Created", Toast.LENGTH_SHORT).show()

                        var intent = Intent(this@SignupActivity, SigninActivity::class.java)
                        finish()
                        startActivity(intent)
                    }
                }else{
                    Toast.makeText(this@SignupActivity, "Confirm Password Doesn't Match", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this@SignupActivity, "Please Enter All Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}