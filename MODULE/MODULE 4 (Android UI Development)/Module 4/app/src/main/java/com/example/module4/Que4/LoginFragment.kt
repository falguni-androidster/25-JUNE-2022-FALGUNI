package com.example.module4.Que4

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.module4.R

class LoginFragment : Fragment() {

    lateinit var edemail : EditText
    lateinit var edpwd : EditText

    lateinit var btnsignin : AppCompatButton
    lateinit var btnreset : AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        edemail = view.findViewById(R.id.ed_email)
        edpwd = view.findViewById(R.id.ed_pwd)

        btnsignin = view.findViewById(R.id.btn_signin)
        btnreset = view.findViewById(R.id.btn_reset)

        btnsignin.setOnClickListener {
            if (edemail.text.toString() != ""){
                if(edpwd.text.toString() != "") {
                var intent = Intent(context,Que4Activity :: class.java)
                startActivity(intent)
                requireActivity().finish()
                }else {
                    Toast.makeText(context, "Please Enter Email", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context, "Please Enter Password", Toast.LENGTH_SHORT).show()
            }
        }

        btnreset.setOnClickListener {
            edemail.text.clear()
            edpwd.text.clear()
        }

        return view
    }

}