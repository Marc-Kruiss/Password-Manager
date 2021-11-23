package com.example.dataexchange

import android.content.Intent
import android.hardware.SensorManager.getOrientation
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataexchange.models.Password
import com.example.dataexchange.models.PasswordAdapter


class MainActivity : AppCompatActivity(),PasswordAdapter.ItemClickListener {

    private lateinit var adapter:PasswordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById<View>(R.id.actionbar_id) as Toolbar
        setSupportActionBar(toolbar)

        // data to populate the RecyclerView with
        // data to populate the RecyclerView with
        val passwords: ArrayList<Password> = arrayListOf(
            Password("goole.com", "Marc", "google"),
            Password("github.com", "Simon", "github"),
            Password("youtube.com", "Jonas", "youtube"),
        )

        // set up the RecyclerView

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvPasswords)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            LinearLayoutManager(this).orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)
        adapter = PasswordAdapter(this, passwords)
        adapter.setClickListener(this)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(applicationContext, "Item 1 Selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item2 -> {
                Toast.makeText(applicationContext, "Item 2 Selected", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item3 -> {
                Toast.makeText(applicationContext, "Item 3 Selected", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    override fun onItemClick(view: View?, position: Int) {
        val passwordEntry = adapter.getItem(position)
        val toPasswordIntent = Intent(this, com.example.dataexchange.Password::class.java)
        Toast.makeText(this, "View Password at " + passwordEntry.url, Toast.LENGTH_SHORT).show()
        toPasswordIntent.putExtra("url", passwordEntry.url)
        toPasswordIntent.putExtra("username", passwordEntry.username)
        toPasswordIntent.putExtra("password", passwordEntry.password)
        startActivity(toPasswordIntent)
    }
}