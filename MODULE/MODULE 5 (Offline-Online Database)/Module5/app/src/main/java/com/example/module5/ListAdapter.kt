package com.example.module5

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.module5.SelectedPicture.SelectedPicActivity
import com.example.module5.StickyNotesApp.NoteDatabase
import com.example.module5.StickyNotesApp.NoteModel
import com.example.module5.StickyNotesApp.NotesActivity
import com.example.module5.TodoApp.TodoActivity

class ListAdapter(var context: Context, var arrayList: ArrayList<ListModel>) : RecyclerView.Adapter<ListAdapter.Myclass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_recylcerview,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        var viewholder = arrayList[position]
        var intent : Intent
        var myshared = context.getSharedPreferences("mypref_file", Context.MODE_PRIVATE)
        var editor = myshared.edit()
        holder.tvrecycler.text = viewholder.textView
        holder.tvrecycler.setOnClickListener {
            if (position == 0){
                intent = Intent(context, TodoActivity :: class.java)
                context.startActivity(intent)
            }else if (position == 1){
                intent = Intent(context, NotesActivity :: class.java)
                context.startActivity(intent)
            }else if (position == 2){
                intent = Intent(context, SelectedPicActivity :: class.java)
                context.startActivity(intent)
            }else if (position == 3){
                editor.putBoolean("status",false)
                editor.apply()
                editor.commit()
                var intent = Intent(context,LoginActivity :: class.java)
                (context as Activity).finish()
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class Myclass(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvrecycler = itemView.findViewById<TextView>(R.id.tv_list)
    }
}