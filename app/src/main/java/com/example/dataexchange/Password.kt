package com.example.dataexchange

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlin.coroutines.*




class Password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        var url:String
        val username:String
        val password:String
        val favIcon:Bitmap

        val extras: Bundle? = intent.extras
        if (extras != null){
            url = extras.getString("url").toString()
            username = extras.getString("username").toString()
            password = extras.getString("password").toString()

            val urlTv = findViewById<TextView>(R.id.url_short_tv)
            val longUrlTv=findViewById<TextView>(R.id.url_long_tv)
            val usernameTv = findViewById<TextView>(R.id.username_tv)
            val passwordTv = findViewById<TextView>(R.id.password_tv)

            //val bitmap = getBitmapFromURL(url)

            urlTv.text=url
            longUrlTv.text= "https://www.$url"
            usernameTv.text=username
            passwordTv.text=password
        }



    }

    fun getBitmapFromURL(src: String): String? {
        var result:String=""
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.google.com/favicon.ico"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, url,
                { response ->
                    // Display the first 500 characters of the response string.
                    result = "Response is: ${response.substring(0, 500)}"
                },
                { result = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
        return result
    }
}