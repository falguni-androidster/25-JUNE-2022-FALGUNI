package com.example.module3

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.module3.que1.HelloActivity
import com.example.module3.que2.ChangeBackgroundActivity
import com.example.module3.que3.NavigateScreenActivity
import com.example.module3.que4.PassDataActivity
import com.example.module3.que5.LoginAndRegistrationActivity
import com.example.module3.que6.RJavaActivity
import com.example.module3.que7.LifecycleActivity
import com.example.module3.que8.FragmentLifecycleActivity
import com.example.module3.que9.AtoFActivity

class MainActivity : AppCompatActivity() {

    lateinit var btnhello : AppCompatButton
    lateinit var btnchangebg : AppCompatButton
    lateinit var btnNavigateScreen : AppCompatButton
    lateinit var btnpassdata : AppCompatButton
    lateinit var btnlogin : AppCompatButton
    lateinit var btnrjava : AppCompatButton
    lateinit var btnlifecycleactivity : AppCompatButton
    lateinit var btnlifecyclefragment : AppCompatButton
    lateinit var btnactivitytofragment : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnhello = findViewById(R.id.btn_1)
        btnchangebg = findViewById(R.id.btn_2)
        btnNavigateScreen = findViewById(R.id.btn_3)
        btnpassdata = findViewById(R.id.btn_4)
        btnlogin = findViewById(R.id.btn_5)
        btnrjava = findViewById(R.id.btn_6)
        btnlifecycleactivity = findViewById(R.id.btn_7)
        btnlifecyclefragment = findViewById(R.id.btn_8)
        btnactivitytofragment = findViewById(R.id.btn_9)

        var intent : Intent

        btnhello.setOnClickListener {
            intent = Intent(this, HelloActivity::class.java)
            startActivity(intent)
        }

        btnchangebg.setOnClickListener {
            intent = Intent(this, ChangeBackgroundActivity::class.java)
            startActivity(intent)
        }

        btnNavigateScreen.setOnClickListener {
            intent = Intent(this, NavigateScreenActivity::class.java)
            startActivity(intent)
        }

        btnpassdata.setOnClickListener {
            intent = Intent(this, PassDataActivity::class.java)
            startActivity(intent)
        }

        btnlogin.setOnClickListener {
            intent = Intent(this, LoginAndRegistrationActivity::class.java)
            startActivity(intent)
        }

        btnrjava.setOnClickListener {
            intent = Intent(this, RJavaActivity::class.java)
            startActivity(intent)
        }

        btnlifecycleactivity.setOnClickListener {
            intent = Intent(this, LifecycleActivity::class.java)
            startActivity(intent)
        }

        btnlifecyclefragment.setOnClickListener {
            intent = Intent(this, FragmentLifecycleActivity::class.java)
            startActivity(intent)
        }

        btnactivitytofragment.setOnClickListener {
            intent = Intent(this,AtoFActivity :: class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit")
            .setMessage("Do you want close this app?")
            .setCancelable(false)
            .setPositiveButton("Exit", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
                finish()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })
            .show()
    }
}