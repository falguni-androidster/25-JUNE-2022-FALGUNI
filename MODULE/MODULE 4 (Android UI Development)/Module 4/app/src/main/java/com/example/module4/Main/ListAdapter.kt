package com.example.module4.Main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module4.Que1.Que1Activity
import com.example.module4.Que2.Que2Activity
import com.example.module4.Que3.Que3Activity
import com.example.module4.Que4.Que4Activity
import com.example.module4.R

class ListAdapter(var context: Context, var arrayList: ArrayList<ListModel>) : RecyclerView.Adapter<ListAdapter.Myclass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.list_recylcerview,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        var viewholder = arrayList[position]
        var intent : Intent
        holder.tvrecycler.text = viewholder.textView
        holder.tvrecycler.setOnClickListener {
            if (position == 0){
                intent = Intent(context, Que1Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 1){
                intent = Intent(context, Que2Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 2){
                intent = Intent(context, Que3Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 3){
                intent = Intent(context, Que4Activity :: class.java)
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