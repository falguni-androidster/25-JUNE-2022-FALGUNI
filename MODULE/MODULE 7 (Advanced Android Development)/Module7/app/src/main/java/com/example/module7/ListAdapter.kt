package com.example.module7

import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.module7.PlaySongFromMobileMemory.FilePlaySongActivity
import com.example.module7.PlaySongFromResource.ResourcePlaySongActivity
import com.example.module7.PlaySongFromServer.ServerPlaySongActivity
import com.example.module7.TextToSpeech.TTSActivity
import com.example.module7.VideoPlayer.VideoActivity
import com.example.module7.Wifi.WifiActivity

class ListAdapter(var context: Context, private var arrayList: ArrayList<ListModel>) : RecyclerView.Adapter<ListAdapter.MyClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_recylcerview,parent,false)
        return MyClass(view)
    }

    override fun onBindViewHolder(holder: MyClass, position: Int) {
        val viewholder = arrayList[position]

        var intent : Intent

        holder.tvrecycler.text = viewholder.textView
        holder.tvrecycler.setOnClickListener {
            when (position) {
                0 -> {
                    intent = Intent(context, ResourcePlaySongActivity :: class.java)
                    context.startActivity(intent)
                }
                1 -> {
                    intent = Intent(context, FilePlaySongActivity :: class.java)
                    context.startActivity(intent)
                }
                2 -> {
                    intent = Intent(context, ServerPlaySongActivity :: class.java)
                    context.startActivity(intent)
                }
                3 -> {
                    intent = Intent(context, VideoActivity :: class.java)
                    context.startActivity(intent)
                }
                4 -> {
                    intent = Intent(context, TTSActivity :: class.java)
                    context.startActivity(intent)
                }
                5 -> {
                    intent = Intent(context, WifiActivity :: class.java)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MyClass(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvrecycler = itemView.findViewById<TextView>(R.id.tv_list)!!
    }
}