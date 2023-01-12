package com.example.mcdelivery.FirstScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mcdelivery.MainScreen.MainScreenActivity
import com.example.mcdelivery.R


class FirstScreenActivity : AppCompatActivity() {

    lateinit var rv_list : RecyclerView
    lateinit var tv_title : TextView
    lateinit var tv_signup : TextView
    lateinit var btn_later : Button
    lateinit var btn_location : Button
    lateinit var lv_list : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firstscreen)

//      Define Arraylist
        var arraylist = ArrayList<FirstScreenModel>()
        arraylist.add(FirstScreenModel( R.drawable.delivery_icon,"Delivery","Super fast food delivery"))
        arraylist.add(FirstScreenModel( R.drawable.ongo_icon,"On The Go","Food delivery to your car/bike"))
        arraylist.add(FirstScreenModel( R.drawable.pickup_icon,"Pick-Up","Pick up from the store"))
        arraylist.add(FirstScreenModel( R.drawable.dinein_icon,"Dine In","Order and dine at the restaurant"))

        //      Define Arraylist
        var scrolllist = ArrayList<ScrollModel>()
        scrolllist.add(ScrollModel( R.drawable.delivery_icon,"Delivery","Enjoy safe and contactless delivery to your doorstep with exciting offers!","Get a free Mcaloo Tikki Burger or Chiken Kabab Burger on orders above Rs.299. Use code - B299"))
        scrolllist.add(ScrollModel( R.drawable.ongo_icon,"On The Go","Delivered to your car at a pick-up point on your way","Free Fries worth Rs.70 on orders above Rs. 199. Use code - OTG199 "))
        scrolllist.add(ScrollModel( R.drawable.pickup_icon,"Pick-Up","Order and Pick-up from one of our restaurants",""))
        scrolllist.add(ScrollModel( R.drawable.dinein_icon,"Dine In","Order online and dine in the restaurant",""))

        rv_list = findViewById(R.id.rv_first_page)
        tv_title = findViewById(R.id.tv_title)
        tv_signup = findViewById(R.id.tv_signup)
        btn_later = findViewById(R.id.btn_learn_more)
        btn_location = findViewById(R.id.btn_pickup_point)

//        Recyclerview slide view
        lv_list = findViewById(R.id.lv_list)
        lv_list.isNestedScrollingEnabled = false
        lv_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        lv_list.setHasFixedSize(true)
        var scrolladapter = ScrollAdapter(this,scrolllist)
        lv_list.adapter = scrolladapter

//      RecyclerView First Page
        rv_list.isNestedScrollingEnabled = false
        rv_list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rv_list.setHasFixedSize(true)

        rv_list.addItemDecoration(DotsIndicatorDecoration())

        var adapter = FirstScreenAdapter(this,arraylist)
        rv_list.adapter = adapter

//      Expanded View
        tv_title.setOnClickListener {

        }

        tv_signup.setOnClickListener {
            
        }

        btn_later.setOnClickListener {
            var intent = Intent(this,MainScreenActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}