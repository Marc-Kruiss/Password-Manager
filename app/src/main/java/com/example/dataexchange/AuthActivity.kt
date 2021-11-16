/*
Marc Kruiß
5BHIF
Data Exchange Between Activities
 */

package com.example.dataexchange
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        val pagerAdapter = AuthenticationPagerAdapter(
            supportFragmentManager
        )
        pagerAdapter.addFragmet(LoginFragment())
        pagerAdapter.addFragmet(RegisterFragment())
        viewPager.adapter = pagerAdapter
    }
}

internal class AuthenticationPagerAdapter(fm: FragmentManager?) :
    FragmentPagerAdapter(fm) {
    private val fragmentList: ArrayList<Fragment> = ArrayList()
    override fun getItem(i: Int): Fragment {
        return fragmentList[i]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragmet(fragment: Fragment) {
        fragmentList.add(fragment)
    }
}