/*
Marc Kruiß
5BHIF
Data Exchange Between Activities
 */

package com.example.dataexchange
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import java.util.*


class AuthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val viewPagerFragmentAdapter:AuthPagerFragmentAdapter= AuthPagerFragmentAdapter(this)

        viewPager.adapter = viewPagerFragmentAdapter
    }
}

class AuthPagerFragmentAdapter(fa:FragmentActivity) : FragmentStateAdapter(fa) {
    val authOptions = arrayOf(String, "login","signup")
    override fun getItemCount(): Int {
        return authOptions.size
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return LoginFragment()
            1 -> return RegisterFragment()
        }
        return LoginFragment()
    }


}