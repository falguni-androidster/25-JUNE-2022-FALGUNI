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

class RegistrationFragment : Fragment() {

    lateinit var edfname : EditText
    lateinit var edlname : EditText
    lateinit var edemail : EditText
    lateinit var edpwd : EditText

    lateinit var btnregistration : AppCompatButton
    lateinit var btnreset : AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_registration, container, false)

        edfname = view.findViewById(R.id.ed_fname)
        edlname = view.findViewById(R.id.ed_lname)
        edemail = view.findViewById(R.id.ed_email)
        edpwd = view.findViewById(R.id.ed_pwd)

        btnregistration = view.findViewById(R.id.btn_signin)
        btnreset = view.findViewById(R.id.btn_reset)

        btnregistration.setOnClickListener {
            if (edfname.text.toString() != "") {
                if (edlname.text.toString() != ""){
                    if (edemail.text.toString() != ""){
                        if (edpwd.text.toString() != ""){
                            var intent = Intent(context,Que4Activity :: class.java)
                            startActivity(intent)
                            requireActivity().finish()
                        }else{
                            Toast.makeText(context, "Please Enter Password", Toast.LENGTH_SHORT).show()
                        }
                    }else{
                        Toast.makeText(context, "Please Enter Email", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(context, "Please Enter Lastname", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context, "Please Enter Firstname", Toast.LENGTH_SHORT).show()
            }
        }

        btnreset.setOnClickListener {
            edfname.text.clear()
            edlname.text.clear()
            edemail.text.clear()
            edpwd.text.clear()
        }

        return view
    }
}