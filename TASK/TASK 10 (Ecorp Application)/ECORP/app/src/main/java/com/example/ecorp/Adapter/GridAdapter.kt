package com.example.ecorp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ecorp.Model.GridViewModal
import com.example.ecorp.R

class GridAdapter(private val context: Context, private val courseList: List<GridViewModal>) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var courseTV: TextView
    private lateinit var courseIV: ImageView

    override fun getCount(): Int {
        return courseList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView == null) {
            convertView = layoutInflater!!.inflate(R.layout.gridview_item, null)
        }

        courseIV = convertView!!.findViewById(R.id.idIVCourse)
        courseTV = convertView!!.findViewById(R.id.idTVCourse)

        courseIV.setImageResource(courseList.get(position).courseImg)
        courseTV.setText(courseList.get(position).courseName)

        return convertView
    }
}