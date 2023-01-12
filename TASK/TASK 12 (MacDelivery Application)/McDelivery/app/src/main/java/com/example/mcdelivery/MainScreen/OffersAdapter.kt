package com.example.mcdelivery.MainScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mcdelivery.R

class OffersAdapter(var context: Context, var arrayList: ArrayList<OffersModel>) : RecyclerView.Adapter<OffersAdapter.Myclass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.offers_recyclerview,parent,false)
        return Myclass(view)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        var viewholder = arrayList[position]
        holder.iv_image.setImageResource(viewholder.iv_offer)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class Myclass(itemView: View): RecyclerView.ViewHolder(itemView) {
        var iv_image = itemView.findViewById<ImageView>(R.id.iv_offers)
    }
}