package com.example.august9task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.text.isDigitsOnly
import kotlin.math.sqrt

class PrimeNumberActivity : AppCompatActivity() {

    lateinit var ednum : EditText
    lateinit var btnprime : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prime_number)

        ednum = findViewById(R.id.ed_prime_num)
        btnprime = findViewById(R.id.btn_prime)

        btnprime.setOnClickListener {
            if(ednum.text.isNotEmpty()) {
                var number = ednum.text.toString().toInt()
                if (isPrimeNo(number)) {
                    Toast.makeText(this, "$number is a Prime Number", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "$number is not a Prime Number", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Enter a valid Number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPrimeNo(number: Int): Boolean {
        if (number <= 1) return false
        for (i in 2..sqrt(number.toDouble()).toInt()) if ( number % i == 0)  return false
        return true
    }
}