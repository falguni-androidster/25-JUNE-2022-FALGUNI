package com.example.module4.Que2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.module4.Main.ListModel
import com.example.module4.R

class Que2DataActivity : AppCompatActivity() {

    lateinit var tv_show : TextView
    lateinit var rvshow_list : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_que2data)

        /* Define Arraylist */
        var list = ArrayList<ListModel>()

        val bundle:Bundle = intent.extras!!
        val num1 = bundle.get("key_num1").toString().toInt()
        val num2 = bundle.get("key_num2").toString().toInt()

        for(num in num1.rangeTo(num2)){
            list.add(ListModel("$num"))
        }

        /* Defind Text Value */
        tv_show = findViewById(R.id.tv_que2_show)
        tv_show.text = "Between Numbers Of $num1 & $num2"

        /* Recycler View */
        rvshow_list = findViewById(R.id.rv_showdata)
        rvshow_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvshow_list.setHasFixedSize(true)

        var dataAdapter = Que2DataAdapter(this,list)
        rvshow_list.adapter = dataAdapter

    }
}