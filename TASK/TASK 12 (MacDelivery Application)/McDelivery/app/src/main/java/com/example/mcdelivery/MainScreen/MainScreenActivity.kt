package com.example.mcdelivery.MainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mcdelivery.R

class MainScreenActivity : AppCompatActivity() {

    lateinit var rv_list : RecyclerView
    lateinit var rv_list_tranding : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen)

        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_search_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //      Define Offer Arraylist
        var listoffer = ArrayList<OffersModel>()
        listoffer.add(OffersModel( R.drawable.offers1 ))
        listoffer.add(OffersModel( R.drawable.offers2 ))
        listoffer.add(OffersModel( R.drawable.offers3 ))
        listoffer.add(OffersModel( R.drawable.offers4 ))

        rv_list = findViewById(R.id.rv_offers)
        rv_list.isNestedScrollingEnabled = false
        rv_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_list.setHasFixedSize(true)
        var offersadapter = OffersAdapter(this,listoffer)
        rv_list.adapter = offersadapter


        //       Define Tranding Arraylist
        var listtranding = ArrayList<TrandingModel>()
        listtranding.add(TrandingModel(R.drawable.offers1,"McAloo Tikki Burger","55"))
        listtranding.add(TrandingModel(R.drawable.offers1,"McAloo Tikki Burger","55"))
        listtranding.add(TrandingModel(R.drawable.offers1,"McAloo Tikki Burger","55"))
        listtranding.add(TrandingModel(R.drawable.offers1,"McAloo Tikki Burger","55"))
        listtranding.add(TrandingModel(R.drawable.offers1,"McAloo Tikki Burger","55"))
        listtranding.add(TrandingModel(R.drawable.offers1,"McAloo Tikki Burger","55"))

        rv_list_tranding = findViewById(R.id.rv_trending)
        rv_list_tranding.isNestedScrollingEnabled = false
        rv_list_tranding.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_list_tranding.setHasFixedSize(true)
        var trandingAdapter = TrandingAdapter(this,listtranding)
        rv_list_tranding.adapter = trandingAdapter

    }
}