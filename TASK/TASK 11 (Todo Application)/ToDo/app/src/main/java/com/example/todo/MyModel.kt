package com.example.todo

import androidx.lifecycle.MutableLiveData




class MyModel(var user_id : Int, var user_task : String, var user_date : String, var user_time : String,var repeat : String, var user_list : String) {

    var mutableLiveData = MutableLiveData<String>()

    fun setText(s: String?) {
        // set value
        mutableLiveData.setValue(s)
    }

    // create get text method
    fun getText(): MutableLiveData<String> {
        return mutableLiveData
    }

}