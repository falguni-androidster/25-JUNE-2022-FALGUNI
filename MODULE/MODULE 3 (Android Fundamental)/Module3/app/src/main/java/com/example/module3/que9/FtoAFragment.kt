package com.example.module3.que9

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.example.module3.R

class FtoAFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_ftoa, container, false)

        var btnActivity = view.findViewById<AppCompatButton>(R.id.btn_activity)

        btnActivity.setOnClickListener {
            var intent = Intent(context,AtoFActivity :: class.java)
            startActivity(intent)
            requireActivity().finish()
        }

        return view
    }
}