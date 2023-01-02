package com.example.module7.Wifi

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.module7.R


class WifiActivity : AppCompatActivity() {

    lateinit var btnWifiOn : AppCompatButton
    lateinit var btnWifiOff : AppCompatButton
    lateinit var wifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi)

        btnWifiOn = findViewById(R.id.btn_wifi_on)
        btnWifiOff = findViewById(R.id.btn_wifi_off)

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        btnWifiOn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(panelIntent, 0)
            } else {
                // for previous android version
                wifiManager.isWifiEnabled = true
            }
            Toast.makeText(this, "Wifi Enabled", Toast.LENGTH_SHORT).show()
        }

        btnWifiOff.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivityForResult(panelIntent, 0)
            } else {
                // for previous android version
                wifiManager.isWifiEnabled = false
            }
            Toast.makeText(this, "Wifi Disabled", Toast.LENGTH_SHORT).show()
        }

    }
}