package com.example.dataexchange

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dataexchange.models.Password
import com.example.dataexchange.models.PasswordAdapter
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(),PasswordAdapter.ItemClickListener {

    private lateinit var adapter: PasswordAdapter
    private lateinit var dl: DrawerLayout
    private lateinit var abdt: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dl = findViewById(R.id.dl)
        abdt = ActionBarDrawerToggle(this, dl, R.string.Open_Nav, R.string.Close_Nav)
        abdt.isDrawerIndicatorEnabled = true


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

        dl.addDrawerListener(abdt)
        abdt.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navView = findViewById<NavigationView>(R.id.nav_view)


        navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_profile -> Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                R.id.item_passwords -> Toast.makeText(this, "Passwords", Toast.LENGTH_SHORT).show()
                R.id.item_settings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()

                else -> Toast.makeText(this, "Invalid Click", Toast.LENGTH_SHORT).show()

            }
            return@OnNavigationItemSelectedListener true
        })
    }

    fun onOptionItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
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