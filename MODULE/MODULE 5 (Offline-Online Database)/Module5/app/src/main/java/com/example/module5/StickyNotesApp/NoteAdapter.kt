package com.example.module5.StickyNotesApp

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.*
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.example.module5.R

class NoteAdapter(var context: Context, var userlist: MutableList<NoteModel>): RecyclerView.Adapter<NoteAdapter.NoteClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteClass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.note_layout,parent,false)
        return NoteClass(view)
    }

    override fun onBindViewHolder(holder: NoteClass, position: Int) {
        var viewholder = userlist[position]
        holder.task.text = viewholder.user_note
        holder.itemView.setOnClickListener {
            var dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_note_updateanddelete)
            dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

            var edtask = dialog.findViewById<EditText>(R.id.ed_dialog_task)
            edtask.setText(viewholder.user_note)
            edtask.setSelection(edtask.text.length)

            var btnupdate = dialog.findViewById<AppCompatButton>(R.id.btn_dialog_update)
            var btndelete = dialog.findViewById<AppCompatButton>(R.id.btn_dialog_delete)

            val db = NoteDatabase(context)
            btnupdate.setOnClickListener {
                var noteModel = NoteModel(viewholder.user_id,edtask.text.toString())
                var updateID = db.update_data(noteModel)
                if(updateID > 0){
                    (context as Activity).finish()
                    (context as Activity).overridePendingTransition( 0, 0)
                    context.startActivity((context as Activity).intent)
                    (context as Activity).overridePendingTransition( 0, 0)
                    dialog.dismiss()
                }else{
                    Toast.makeText(context, "Task not updated", Toast.LENGTH_SHORT).show()
                }
            }

            btndelete.setOnClickListener {
                val db = NoteDatabase(context)
                val noteModel = NoteModel(viewholder.user_id, viewholder.user_note)
                db.delete_data(noteModel)
                userlist.remove(noteModel)
                (context as Activity).finish()
                (context as Activity).overridePendingTransition( 0, 0)
                context.startActivity((context as Activity).intent)
                (context as Activity).overridePendingTransition( 0, 0)
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    class NoteClass(view: View): RecyclerView.ViewHolder(view){
        var task = view.findViewById<TextView>(R.id.tv_note)
    }
}