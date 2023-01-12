package com.example.mcdelivery.FirstScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mcdelivery.R

class FirstScreenAdapter(var context: Context, var arrayList: ArrayList<FirstScreenModel>) : RecyclerView.Adapter<FirstScreenAdapter.Myclass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.firstscreen_recyclerview,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        var viewholder = arrayList[position]
        holder.iv_image.setImageResource(viewholder.iv_first)
        holder.tv_title.text = viewholder.tv_title
        holder.tv_name.text = viewholder.tv_discription
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class Myclass(itemView:View): RecyclerView.ViewHolder(itemView) {
        var iv_image = itemView.findViewById<ImageView>(R.id.iv_first_page_image)
        var tv_title = itemView.findViewById<TextView>(R.id.tv_first_page_title)
        var tv_name = itemView.findViewById<TextView>(R.id.tv_first_page_name)
    }
}
