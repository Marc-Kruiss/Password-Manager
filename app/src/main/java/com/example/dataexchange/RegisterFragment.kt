package com.example.dataexchange

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast


class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val loginBtn: Button = view.findViewById(R.id.btn_register)
        loginBtn.setOnClickListener(){
            Toast.makeText(activity,"Register", Toast.LENGTH_SHORT).show();
        }
        return view
    }
}