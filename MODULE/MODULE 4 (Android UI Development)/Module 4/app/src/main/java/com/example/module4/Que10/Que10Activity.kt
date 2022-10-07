package com.example.module4.Que10

import android.Manifest
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Environment
import android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import com.example.module4.R
import java.io.File


class Que10Activity : AppCompatActivity() {

    val REQUEST_EXTERNAL_STORAGE = 1
    val PERMISSION_STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
    )

    lateinit var btnopenpdf : AppCompatButton
    lateinit var pdfOpenIntent : Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que10)

        val permission = ActivityCompat.checkSelfPermission(this!!, WRITE_EXTERNAL_STORAGE)

        if (SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager() && permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, PERMISSION_STORAGE, REQUEST_EXTERNAL_STORAGE)
                val intent = Intent()
                intent.action = ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION
                val uri: Uri = Uri.fromParts("package", this.packageName, null)
                intent.data = uri
                startActivity(intent)
            }
        }

        btnopenpdf = findViewById(R.id.btn_que10_openpdf)
        btnopenpdf.setOnClickListener {

            val file = File(Environment.getExternalStorageDirectory(), "Download/androidwithkotlin_assignment.pdf")
            val uriPdfPath =
                FileProvider.getUriForFile(this, applicationContext.packageName + ".provider", file)
            pdfOpenIntent = Intent(Intent.ACTION_VIEW)
            pdfOpenIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            pdfOpenIntent.clipData = ClipData.newRawUri("", uriPdfPath)
            pdfOpenIntent.setDataAndType(uriPdfPath, "application/pdf")
            pdfOpenIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            try {
                startActivity(pdfOpenIntent)
            } catch (activityNotFoundException: ActivityNotFoundException) {
                Toast.makeText(this, "To Load PDF", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}