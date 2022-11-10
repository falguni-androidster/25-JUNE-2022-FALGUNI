 package com.example.module5.StickyNotesApp

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.module5.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

 class NotesActivity : AppCompatActivity() {

     lateinit var fabadd : FloatingActionButton
     lateinit var tvnothing : TextView

     lateinit var recycler: RecyclerView

     var datalist : MutableList<NoteModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val actionbar: ActionBar? = supportActionBar
        actionbar!!.setDisplayShowTitleEnabled(true)
        actionbar.title = "StickyNotes App"

        tvnothing = findViewById(R.id.tv_notes_nothing)

        fabadd = findViewById(R.id.fab_add_notes)

        recycler = findViewById(R.id.rv_note_list)
        recycler.layoutManager = LinearLayoutManager(this)
        var myDatabase = NoteDatabase(this)
        datalist = myDatabase.getAll_Data()

        if (datalist.size == 0) {
            tvnothing.visibility = View.VISIBLE
            recycler.visibility = View.GONE
        }else{
            tvnothing.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }
        var noteAdapter = NoteAdapter(this, datalist)
        recycler.adapter = noteAdapter

        fabadd.setOnClickListener {
            var dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_addnote)
            dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

            var edtask = dialog.findViewById<EditText>(R.id.ed_note)
            var btnadd = dialog.findViewById<AppCompatButton>(R.id.btn_dialog_add)

            btnadd.setOnClickListener {
                if(edtask.text.toString() != ""){
                    var myDatabase = NoteDatabase(this)
                    var insertID = myDatabase.insert(NoteModel(it.id!!,edtask.text.toString()))
                    if (insertID > 0){
                        finish()
                        overridePendingTransition( 0, 0)
                        startActivity(intent)
                        overridePendingTransition( 0, 0)
                        dialog.dismiss()
                    } else{
                        Toast.makeText(this, "Note Inserted", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, " Please Enter Note", Toast.LENGTH_SHORT).show()
                }
            }
            dialog.show()
        }
    }
}