package com.example.august9task

import android.content.Intent
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.widget.AppCompatButton

class TaskAdapter(private val context: Context,
                  private val dataSource: ArrayList<String>) : BaseAdapter(){

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(p0: Int): Any {
        return dataSource[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var intent : Intent
        val view = inflater.inflate(R.layout.task_list, p2, false)
        val btnlist = view.findViewById(R.id.btn_list) as AppCompatButton
        btnlist.text = getItem(p0).toString()
        btnlist.setOnClickListener {
            if (p0 == 0){
                intent = Intent(context,FactorialActivity::class.java)
                context.startActivity(intent)
            }else if (p0 == 1){
                intent = Intent(context,PrimeNumberActivity::class.java)
                context.startActivity(intent)
            }else if (p0 == 2){
                intent = Intent(context,EvenOddNumberActivity::class.java)
                context.startActivity(intent)
            }else if (p0 == 3){
                intent = Intent(context,YearToMonthActivity::class.java)
                context.startActivity(intent)
            }else if (p0 == 4){
                intent = Intent(context,DaysToMonthActivity::class.java)
                context.startActivity(intent)
            }else if (p0 == 5){
                intent = Intent(context,InterestActivity::class.java)
                context.startActivity(intent)
            }else if (p0 == 6){
                intent = Intent(context,AreaActivity::class.java)
                context.startActivity(intent)
            }
        }
        return view
    }
}
