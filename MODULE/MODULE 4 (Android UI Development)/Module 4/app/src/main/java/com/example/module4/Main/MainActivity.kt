package com.example.module4.Main

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.module4.R

class MainActivity : AppCompatActivity() {

    lateinit var recycler_list : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Define Arraylist */
        var list = ArrayList<ListModel>()
        list.add(ListModel("( 1 ) Create an application to take input number from user and print its reverse number in TextView without button."))
        list.add(ListModel("( 2 ) Create an application to input 2 numbers from user and all numbers between those 2 numbers in next activity."))
        list.add(ListModel("( 3 ) Create an application with radio buttons (Add, Subtraction, Multiply, Division) EditText (number1, number2) and print result as per user choice from radio button in TextView."))
        list.add(ListModel("( 4 ) Write a code to display login form when click on login button and registration form when click on registration button on single activity using fragment."))
        list.add(ListModel("( 5 ) Create an application to load google url into webview also manage forward and backward redirect."))
        list.add(ListModel("( 6 ) In Previous Practical write code to check weather internet connection is available or not if."))
        list.add(ListModel("( 7 ) No internet connection then display message accordingly."))
        list.add(ListModel("( 8 ) Create an application to hide TextView when first button click and show when second button click."))
        list.add(ListModel("( 9 ) Create an application to add TextView in TableLayout Programmatically."))
        list.add(ListModel("( 10 ) Create an application to open pdf using implicit intent."))
        list.add(ListModel("( 11 ) Create an application to increate font size when plus button click and decrease when minus button click."))
        list.add(ListModel("( 12 ) Create an application to display n edittext where n is number input by user."))
        list.add(ListModel("( 13 ) Create an application to display Textview when checkbox is checked and hide otherwise A6 Write a program to show four images around Textview."))
        list.add(ListModel("( 14 ) Write a program to create one string array in string.xml file and that array show in listview."))
        list.add(ListModel("( 15 ) Write a program in android display screen color which the Color will be select from the radio button."))
        list.add(ListModel("( 16 ) Write a program you have taken three seek bar controls. From three Seekbar which Seek bar value changed the background color of device will be changed."))
        list.add(ListModel("( 17 ) Create toolbar with spinner and search functionality."))

        /* Recycler View */
        recycler_list = findViewById(R.id.rv_list)
        recycler_list.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        recycler_list.setHasFixedSize(true)

        var listAdapter = ListAdapter(this,list)
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