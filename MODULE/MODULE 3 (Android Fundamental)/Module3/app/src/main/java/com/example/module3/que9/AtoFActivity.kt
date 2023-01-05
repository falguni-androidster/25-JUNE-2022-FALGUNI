package com.example.module3.que9

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.module3.MainActivity
import com.example.module3.R


class AtoFActivity : AppCompatActivity() {

    lateinit var btnFragment : AppCompatButton
    lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atof)

        frameLayout = findViewById(R.id.container)
        btnFragment = findViewById(R.id.btn_fragment)

        btnFragment.setOnClickListener {
            frameLayout.removeAllViewsInLayout()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container,FtoAFragment())
            transaction.commit()
        }
    }

}