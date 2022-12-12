package com.example.ecorp.Activity

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.ecorp.*
import com.example.ecorp.Adapter.GridAdapter
import com.example.ecorp.Model.GridViewModal

class DashboardActivity : AppCompatActivity() {

    lateinit var myshared : SharedPreferences
    lateinit var editor : SharedPreferences.Editor

    lateinit var gridview : GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        myshared = this.getSharedPreferences("ecorppref_file", Context.MODE_PRIVATE)
        editor = myshared.edit()

        gridview = findViewById(R.id.grid_layout)

        var list = ArrayList<GridViewModal>()
        list.add(GridViewModal("Play Quiz", R.drawable.play_quiz))
        list.add(GridViewModal("Read Question", R.drawable.read_question))

        val courseAdapter = GridAdapter(courseList = list, context = this@DashboardActivity)
        gridview.adapter = courseAdapter

        gridview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            if(position == 0){
                var intent = Intent(this@DashboardActivity, PlayQuizActivity :: class.java)
                startActivity(intent)
            }else if (position == 1){
                var intent = Intent(this@DashboardActivity, ReadQuestionActivity :: class.java)
                startActivity(intent)
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.op_aboutus -> {
                Toast.makeText(this@DashboardActivity, "About Us", Toast.LENGTH_SHORT).show()
            }

            R.id.op_contactus -> {
                Toast.makeText(this@DashboardActivity, "Contact Us", Toast.LENGTH_SHORT).show()
            }

            R.id.op_logout -> {
                editor.putBoolean("status",false)
                editor.apply()
                editor.commit()

                var intent = Intent(this, SigninActivity :: class.java)
                finish()
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
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