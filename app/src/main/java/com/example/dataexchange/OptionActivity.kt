package com.example.dataexchange

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        val extras = intent.extras
        if (extras != null) { // are extras available?
            // get extras by keys
            //The key argument here must match that used in the other activity
            val username = extras.getString("username")
            val password = extras.getString("password")
            val textView = findViewById<TextView>(R.id.textViewId) // define textview for credentials output message
            textView.text = String.format("Logged in user '$username' with password '$password'") // set output text
        }

        // simple setup for backbutton-function
        val button = findViewById<Button>(R.id.backBtnId)
        button.setOnClickListener{
            onBackPressed()
        }
    }
}