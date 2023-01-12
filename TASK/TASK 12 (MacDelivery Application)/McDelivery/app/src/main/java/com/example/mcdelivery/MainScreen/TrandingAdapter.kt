package com.example.mcdelivery.MainScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mcdelivery.R

class TrandingAdapter(var context: Context, var arrayList: ArrayList<TrandingModel>) : RecyclerView.Adapter<TrandingAdapter.Trandingclass>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Trandingclass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.tranding_recyclerview, parent, false)
        return Trandingclass(view)
    }

    override fun onBindViewHolder(holder: Trandingclass, position: Int) {
        var viewholder = arrayList[position]
        holder.iv_image.setImageResource(viewholder.image)
        holder.tv_name.setText(viewholder.name)
        holder.tv_price.setText(viewholder.price)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class Trandingclass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_image = itemView.findViewById<ImageView>(R.id.iv_tranding)
        var tv_name = itemView.findViewById<TextView>(R.id.tv_tranding_name)
        var tv_price = itemView.findViewById<TextView>(R.id.tv_tranding_price)

    }
}