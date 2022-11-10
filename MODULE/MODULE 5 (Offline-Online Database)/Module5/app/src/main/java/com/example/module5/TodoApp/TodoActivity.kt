package com.example.module5.TodoApp

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.module5.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    lateinit var fabadd : FloatingActionButton
    lateinit var tvnothing : TextView

    lateinit var recycler: RecyclerView

    var datalist : MutableList<TodoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val actionbar: ActionBar? = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_check_circle_24)
        actionbar.setDisplayShowTitleEnabled(true)
        actionbar.title = "ToDo App"

        tvnothing = findViewById(R.id.tv_nothing)

        fabadd = findViewById(R.id.fab_add)
        fabadd.setOnClickListener {
            var intent = Intent(this, TodoTaskActivity::class.java)
            intent.putExtra("update",true)
            finish()
            startActivity(intent)
        }

        recycler = findViewById(R.id.rv_tasklist)
        recycler.layoutManager = LinearLayoutManager(this)
        var myDatabase = TodoDatabase(this)
        datalist = myDatabase.getAll_Data()

        if (datalist.size == 0) {
            tvnothing.visibility = View.VISIBLE
            recycler.visibility = View.GONE
        }else{
            tvnothing.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }

        var dataAdapter = TodoAdapter(this, datalist,tvnothing)
        recycler.adapter = dataAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tasklist -> Toast.makeText(this, "Task List", Toast.LENGTH_SHORT).show()
            R.id.batchmode -> Toast.makeText(this, "Batch Mode", Toast.LENGTH_SHORT).show()
            R.id.remove -> Toast.makeText(this, "Remove Ads", Toast.LENGTH_SHORT).show()
            R.id.moreapps -> Toast.makeText(this, "More Apps", Toast.LENGTH_SHORT).show()
            R.id.feedback -> Toast.makeText(this, "Send Feedback", Toast.LENGTH_SHORT).show()
            R.id.follow -> Toast.makeText(this, "Follow us", Toast.LENGTH_SHORT).show()
            R.id.invitefriend -> Toast.makeText(this, "Invite friends to the app", Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
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