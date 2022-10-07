package com.example.module4.Main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module4.Que1.Que1Activity
import com.example.module4.Que10.Que10Activity
import com.example.module4.Que11.Que11Activity
import com.example.module4.Que12.Que12Activity
import com.example.module4.Que13.Que13Activity
import com.example.module4.Que14.Que14Activity
import com.example.module4.Que15.Que15Activity
import com.example.module4.Que16.Que16Activity
import com.example.module4.Que17.Que17Activity
import com.example.module4.Que2.Que2Activity
import com.example.module4.Que3.Que3Activity
import com.example.module4.Que4.Que4Activity
import com.example.module4.Que5.Que5Activity
import com.example.module4.Que6.Que6Activity
import com.example.module4.Que7.Que7Activity
import com.example.module4.Que8.Que8Activity
import com.example.module4.Que9.Que9Activity
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
            }else if (position == 4){
                intent = Intent(context, Que5Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 5){
                intent = Intent(context, Que6Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 6){
                intent = Intent(context, Que7Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 7){
                intent = Intent(context, Que8Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 8){
                intent = Intent(context, Que9Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 9){
                intent = Intent(context, Que10Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 10){
                intent = Intent(context, Que11Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 11){
                intent = Intent(context, Que12Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 12){
                intent = Intent(context, Que13Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 13){
                intent = Intent(context, Que14Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 14){
                intent = Intent(context, Que15Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 15){
                intent = Intent(context, Que16Activity :: class.java)
                context.startActivity(intent)
            }else if (position == 16){
                intent = Intent(context, Que17Activity :: class.java)
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