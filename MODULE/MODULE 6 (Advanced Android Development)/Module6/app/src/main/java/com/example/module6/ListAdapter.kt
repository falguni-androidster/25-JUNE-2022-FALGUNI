package com.example.module6

import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module6.Que1.GoogleMapsActivity
import com.example.module6.Que2.NotificationActivity
import com.example.module6.Que3.RotateBlinkImageActivity
import com.example.module6.Que4.MoveZoomImageActivity
import com.example.module6.Que5.FrameAnimActivity

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
                intent = Intent(context, GoogleMapsActivity :: class.java)
                context.startActivity(intent)
            }else if (position == 1){
                intent = Intent(context, NotificationActivity :: class.java)
                context.startActivity(intent)
            }else if (position == 2){
                intent = Intent(context, RotateBlinkImageActivity :: class.java)
                context.startActivity(intent)
            }else if (position == 3){
                intent = Intent(context, MoveZoomImageActivity :: class.java)
                context.startActivity(intent)
            }else if (position == 4){
                intent = Intent(context, FrameAnimActivity :: class.java)
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