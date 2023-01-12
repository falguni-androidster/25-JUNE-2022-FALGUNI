package com.example.mcdelivery.FirstScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mcdelivery.R

class ScrollAdapter(var context: Context, var scrolllist: ArrayList<ScrollModel>) : RecyclerView.Adapter<ScrollAdapter.Scrollclass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Scrollclass {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_list_showhide, parent, false)
        return Scrollclass(view)
    }

    override fun onBindViewHolder(holder: Scrollclass, position: Int) {
        var viewholder = scrolllist[position]
        holder.title.text = viewholder.title
        holder.description.text = viewholder.description
        holder.offer.text = viewholder.offer
        holder.image.setImageResource(viewholder.deliveryIcon)
    }

    override fun getItemCount(): Int {
        return scrolllist.size
    }

    class Scrollclass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.tv_slide_title)
        var description = itemView.findViewById<TextView>(R.id.tv_slide_description)
        var offer = itemView.findViewById<TextView>(R.id.tv_slide_offer)
        var image = itemView.findViewById<ImageView>(R.id.iv_slide_image)
    }
}