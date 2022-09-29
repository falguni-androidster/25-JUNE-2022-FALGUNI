package com.example.module4.Que2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.module4.R

class Que2Activity : AppCompatActivity() {

    lateinit var ednum1 : EditText
    lateinit var ednum2 : EditText
    lateinit var btnnext : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que2)

        ednum1 = findViewById(R.id.ed_que2_num1)
        ednum2 = findViewById(R.id.ed_que2_num2)
        btnnext = findViewById(R.id.btn_que2)

        var num1 = ednum1.text
        var num2 = ednum2.text

        btnnext.setOnClickListener {
            if(num1.toString()!= "" && num2.toString()!= "" && num1.toString().toInt() > 0 && num2.toString().toInt() > 0){
                if(num1.toString() <= num2.toString() && num1.toString() != num2.toString()){
                    var intent = Intent(this, Que2DataActivity :: class.java)
                    intent.putExtra("key_num1",num1)
                    intent.putExtra("key_num2",num2)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Please Enter Valid Number", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Please Enter Number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}