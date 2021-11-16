package com.example.dataexchange

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ResetPasswortActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_passwort)

        val resetBtn: Button = findViewById(R.id.btn_reset)
        resetBtn.setOnClickListener {
            Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
        }

        val loginBtn: Button = findViewById(R.id.btn_login)
        loginBtn.setOnClickListener {
            /*val resetPasswordIntent = Intent(this, AuthActivity::class.java)
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
            startActivity(resetPasswordIntent)*/
            onBackPressed()
        }
    }
}