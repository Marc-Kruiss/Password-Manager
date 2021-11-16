/*
Marc Kruiß
5BHIF
Data Exchange Between Activities
 */

package com.example.dataexchange

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.intentBtnId) // button for triggering new intent
        button.setOnClickListener{
            val intent = changeActivity() // when clicked try to change activity
            if (intent!=null)
                // execute intent
                startActivity(intent)
        }
    }

    private fun changeActivity(): Intent? {
        // get input text data
        val username = getTextFromTextView(R.id.usernameTextId, optionalErrorMessage = "You need to enter a Username!")
        val password = getTextFromTextView(R.id.passwordTextId, optionalErrorMessage = "Password-field can't be empty")
        // validate login credentials
        return if (username == "" || password == ""){ // are credentials invalid?
            null
        } else{
            // setup intent
            Intent(this, OptionActivity::class.java).apply {
                // setup extra data for the following activity
                putExtra("username", username)
                putExtra("password", password)
            }
        }

    }

    /*
    Validate and get text from view
    optional Error message if not text was found
     */
    private fun getTextFromTextView(viewId:Int, optionalErrorMessage:String=""): String {
        val view = findViewById<TextView>(viewId) // get textview via viewId
        val text = view.text.toString()
        if (text==""){ // is input text invalid?
            view.error = optionalErrorMessage // set error message on view
            Toast.makeText(applicationContext, "Wrong input!",Toast.LENGTH_LONG).show()
            return ""
        }
        return text
    }
}