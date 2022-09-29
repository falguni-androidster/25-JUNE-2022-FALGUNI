package com.example.module4.Que2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module4.Main.ListModel
import com.example.module4.R

class Que2DataAdapter(var context: Context, var arrayList: ArrayList<ListModel>) : RecyclerView.Adapter<Que2DataAdapter.MyData>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyData {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_recylcerview, parent, false)
        return MyData(view)
    }

    override fun onBindViewHolder(holder: MyData, position: Int) {
        var viewholder = arrayList[position]
        holder.tvrecycler.text = viewholder.textView
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvrecycler = itemView.findViewById<TextView>(R.id.tv_list)
    }
}