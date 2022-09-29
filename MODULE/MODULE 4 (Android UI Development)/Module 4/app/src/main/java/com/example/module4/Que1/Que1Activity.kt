package com.example.module4.Que1

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.module4.R
import kotlin.text.toInt as textToInt


class Que1Activity : AppCompatActivity() {

    lateinit var edreverse : EditText
    lateinit var tvreverse : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que1)

        edreverse = findViewById(R.id.ed_que1)
        tvreverse = findViewById(R.id.tv_que1)

        edreverse.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (s.toString() != ""){
                    var num = s.toString().textToInt()
                    var reverse = 0
                    while (num != 0) {
                        reverse = reverse * 10 + num % 10
                        num /= 10
                    }
                    tvreverse.text = reverse.toString()
                }else{
                    tvreverse.text = ""
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }
}