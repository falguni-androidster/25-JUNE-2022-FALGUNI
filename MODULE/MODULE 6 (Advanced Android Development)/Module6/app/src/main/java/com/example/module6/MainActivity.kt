package com.example.module6

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recycler_list: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Define Arraylist */
        var list = ArrayList<ListModel>()
        list.add(ListModel("( 1 ) Create an application to display Google map with current location also give options to change mode in map"))
        list.add(ListModel("( 2 ) Create an application to input address and display marker on that address"))
        list.add(ListModel("( 3 ) Create an application to suggest places as user type with help of Place autocomplete"))
        list.add(ListModel("( 4 ) Write a code to rotate image Write a code to blink image"))
        list.add(ListModel("( 5 ) Write a code to move image from one place to another place Write a code to zoom in / out image using animation"))
        list.add(ListModel("( 6 ) Write a code to show progress frame by frame animation"))

        /* Recycler View */
        recycler_list = findViewById(R.id.rv_list)
        recycler_list.layoutManager = LinearLayoutManager(this)
        recycler_list.setHasFixedSize(true)

        var listAdapter = ListAdapter(this, list)
        recycler_list.adapter = listAdapter

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