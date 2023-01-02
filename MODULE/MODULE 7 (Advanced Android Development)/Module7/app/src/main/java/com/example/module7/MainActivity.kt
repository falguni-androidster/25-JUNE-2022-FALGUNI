package com.example.module7

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Define Arraylist */
        var list = ArrayList<ListModel>()
        list.add(ListModel("( 1 ) Create an application to play song from raw resource folder."))
        list.add(ListModel("( 2 ) Create an application to play song from mobile memory."))
        list.add(ListModel("( 3 ) Create an application to play song from Server."))
        list.add(ListModel("( 4 ) Use WAKE LOCK when playing video play."))
        list.add(ListModel("( 5 ) Create an application to convert text typed in edit text into speech."))
        list.add(ListModel("( 6 ) Create an application for Wi-Fi on-off."))

        /* Recycler View */
        recyclerView = findViewById(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        var listAdapter = ListAdapter(this, list)
        recyclerView.adapter = listAdapter

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