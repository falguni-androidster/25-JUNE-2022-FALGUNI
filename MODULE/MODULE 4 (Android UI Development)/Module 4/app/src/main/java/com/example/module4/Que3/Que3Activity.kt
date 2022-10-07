package com.example.module4.Que3

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import com.example.module4.R

class Que3Activity : AppCompatActivity() {

    lateinit var rglist : RadioGroup
    lateinit var radioButton : RadioButton

    lateinit var ednum1 : EditText
    lateinit var ednum2 : EditText

    lateinit var btnshow : AppCompatButton
    lateinit var tvshow : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que3)

        rglist = findViewById(R.id.rg_list)

        ednum1 = findViewById(R.id.ed_que3_num1)
        ednum2 = findViewById(R.id.ed_que3_num2)

        btnshow = findViewById(R.id.btn_que3_show)
        btnshow.visibility = View.INVISIBLE
        tvshow = findViewById(R.id.tv_que3_show)

        rglist.setOnCheckedChangeListener { radioGroup, i ->
            radioButton = findViewById(i)
            btnshow.text = radioButton.text
            btnshow.visibility = View.VISIBLE
            btnshow.setOnClickListener {
                if (ednum1.text.toString() != "" && ednum2.text.toString() != ""){
                    var num1 = ednum1.text.toString().toFloat()
                    var num2 = ednum2.text.toString().toFloat()
                    if (i == R.id.rb_add){
                        var add = num1 + num2
                        tvshow.text = "$add"
                    }else if (i == R.id.rb_sub){
                        var sub = num1 - num2
                        tvshow.text = "$sub"
                    }else if (i == R.id.rb_mul){
                        var mul = num1 * num2
                        tvshow.text = "$mul"
                    }else if (i == R.id.rb_div){
                        var div = num1 / num2
                        tvshow.text = "$div"
                    }
                }else {
                    Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}