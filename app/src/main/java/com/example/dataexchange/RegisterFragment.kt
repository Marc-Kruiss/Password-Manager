package com.example.dataexchange

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment


class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        val loginBtn: Button = view.findViewById(R.id.btn_register)
        loginBtn.setOnClickListener(){
            val mainIntent = Intent(this.context, MainActivity::class.java)
            Toast.makeText(activity, "Reginster", Toast.LENGTH_SHORT).show()
            startActivity(mainIntent)
        }
        return view
    }
}