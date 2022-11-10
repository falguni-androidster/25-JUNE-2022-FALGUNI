package com.example.module5.TodoApp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.module5.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoTaskActivity : AppCompatActivity() {

    lateinit var edtask : EditText
    lateinit var eddate : EditText
    lateinit var edtime : EditText

    lateinit var mic : ImageView
    val SPEECH_REQUEST_CODE = 0

    lateinit var dateimage : ImageView
    lateinit var timeimage : ImageView
    @SuppressLint("NewApi")
    var calender = Calendar.getInstance()

    lateinit var newlist : ImageView

    lateinit var sprepeat : Spinner
    lateinit var sptask : Spinner

    lateinit var fabadd : FloatingActionButton

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_task)

        val actionbar: ActionBar? = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_check_circle_24)
        actionbar.setDisplayShowTitleEnabled(true)
        actionbar.title = "ToDo App"

        var status = intent.getBooleanExtra("update",false)

        edtask = findViewById(R.id.ed_task)
        mic = findViewById(R.id.iv_mic)
        mic.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            }
            startActivityForResult(intent, SPEECH_REQUEST_CODE)
        }

        eddate = findViewById(R.id.ed_date)
        dateimage = findViewById(R.id.iv_date)
        dateimage.setOnClickListener {
            DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val m = i2 + 1
                eddate.setText("$i3-$m-$i")
                eddate.setSelection(eddate.length())
            }, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH))
                .show()
        }

        edtime = findViewById(R.id.ed_time)
        timeimage = findViewById(R.id.iv_time)
        timeimage.setOnClickListener {
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                val isPM: Boolean = i >= 12
                edtime.setText(java.lang.String.format("%02d:%02d %s", if (i == 12 || i == 0) 12 else i % 12, i2, if (isPM) "PM" else "AM"))
                edtime.setSelection(edtime.length())
            }, calender.get(Calendar.HOUR_OF_DAY), calender.get(Calendar.MINUTE), false)
                .show()
        }

        var repeatlist = ArrayList<String>()
        repeatlist.add("No repeat")
        repeatlist.add("Once a Day")
        repeatlist.add("Once a Day (Mon-Fri)")
        repeatlist.add("Once a Week")
        repeatlist.add("Once a Month")
        repeatlist.add("Once a Year")
        repeatlist.add("Other...")
        sprepeat = findViewById(R.id.sp_repeat)
        var repeatAdapter = ArrayAdapter(this,R.layout.spinner_text,repeatlist)
        sprepeat.adapter = repeatAdapter

        /*if(sprepeat.selectedItem.toString() == "Other..."){

        }*/

        var tasklist = ArrayList<String>()
        tasklist.add("Default")
        tasklist.add("Personal")
        tasklist.add("Shopping")
        tasklist.add("Wishlist")
        tasklist.add("Work")
        sptask = findViewById(R.id.sp_addlist)
        var taskAdapter = ArrayAdapter(this,R.layout.spinner_text,tasklist)
        sptask.adapter = taskAdapter

        newlist = findViewById(R.id.iv_addlist)
        newlist.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.add_todotask)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

            var ednewtask = dialog.findViewById<EditText>(R.id.ed_new_task)
            var btnadd = dialog.findViewById<Button>(R.id.btn_add_list)
            var btncancel = dialog.findViewById<Button>(R.id.btn_cancel_list)

            btnadd.setOnClickListener {
                tasklist.add(ednewtask.text.toString())
                var taskAdapter = ArrayAdapter(this,R.layout.spinner_text,tasklist)
                sptask.adapter = taskAdapter
                (taskAdapter as ArrayAdapter<String>).filter.filter(ednewtask.text)
                dialog.dismiss()
            }
            btncancel.setOnClickListener {
                dialog.cancel()
            }
            dialog.show()
        }

        /* Update task */
        if (!status){
            var task = intent.getStringExtra("task").toString()
            var date = intent.getStringExtra("date").toString()
            var time = intent.getStringExtra("time").toString()
            var repeat = intent.getStringExtra("repeat").toString()
            var list = intent.getStringExtra("list").toString()

            edtask.setText(task)
            edtask.setSelection(edtask.length())
            eddate.setText(date)
            edtime.setText(time)

            val sprepeatposition : Int = repeatAdapter.getPosition(repeat)
            sprepeat.setSelection(sprepeatposition)

            val sptaskposition : Int = taskAdapter.getPosition(list)
            sptask.setSelection(sptaskposition)
        }

        var myDatabase = TodoDatabase(this)
        fabadd = findViewById(R.id.fab_add_task)
        fabadd.setOnClickListener {
            if(edtask.text.toString() != ""){
                if (eddate.text.toString() != ""){
                   if (edtime.text.toString() != ""){
                       if (!status){
                           var id = intent.getIntExtra("id",0)
                           var myModel = TodoModel(id!!,edtask.text.toString(),eddate.text.toString(),edtime.text.toString(),sprepeat.selectedItem.toString(),sptask.selectedItem.toString())
                           var updateID = myDatabase.update_data(myModel)
                           if(updateID > 0){
                               var intent = Intent(this,TodoActivity::class.java)
                               finish()
                               startActivity(intent)
                           }else{
                               Toast.makeText(this, "Task not updated", Toast.LENGTH_SHORT).show()
                           }
                       }else{
                           var insertID = myDatabase.insert(TodoModel(it.id!!,edtask.text.toString(),eddate.text.toString(),edtime.text.toString(),sprepeat.selectedItem.toString(),sptask.selectedItem.toString()))
                           if (insertID > 0){
                               var intent = Intent(this,TodoActivity::class.java)
                               finish()
                               startActivity(intent)
                           } else{
                               Toast.makeText(this, "Task not Inserted", Toast.LENGTH_SHORT).show()
                           }
                       }
                   } else{
                       Toast.makeText(this, " Please Enter Time", Toast.LENGTH_SHORT).show()
                   }
                }else{
                    Toast.makeText(this, " Please Enter Date", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, " Please Enter Task", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText = data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results -> results!![0] }
            edtask.setText(spokenText)
            edtask.setSelection(edtask.length())
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onBackPressed() {
        var intent = Intent(this,TodoActivity::class.java)
        finish()
        startActivity(intent)
    }
}