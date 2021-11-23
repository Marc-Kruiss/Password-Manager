package com.example.dataexchange

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val loginBtn:Button = view.findViewById(R.id.btn_reset)
        loginBtn.setOnClickListener(){
            val mainIntent = Intent(this.context, MainActivity::class.java)
            Toast.makeText(activity, "Login", Toast.LENGTH_SHORT).show()
            startActivity(mainIntent)
        }

        val forgotPasswordBtn:Button = view.findViewById(R.id.btn_forgot_password)
        forgotPasswordBtn.setOnClickListener {
            val resetPasswordIntent = Intent(this.context, ResetPasswortActivity::class.java)
            Toast.makeText(activity, "Reset Passwort", Toast.LENGTH_SHORT).show()
            startActivity(resetPasswordIntent)
        }
        return view
    }
}
