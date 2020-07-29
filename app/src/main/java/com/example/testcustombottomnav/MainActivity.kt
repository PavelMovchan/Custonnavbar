package com.example.testcustombottomnav

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    val userProfileFragment: Fragment1 = Fragment1() // first fragment for first tab (controller1)
    val searchFragment: Fragment2 =  Fragment2() // first fragment for second tab (controller2)

    lateinit var controller1: FragmentContainerView // for first tab
    lateinit var controller2: FragmentContainerView // for second tab

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFraments()
        setupBottomNavigationBar()
    }

    private fun initFraments() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.profile_nav_host, userProfileFragment)
            add(R.id.search_nav_host, searchFragment)
        }.commit()

        controller1 = findViewById(R.id.profile_nav_host)
        controller2 = findViewById(R.id.search_nav_host)
        controller2.visibility = View.INVISIBLE
    }

    private fun setupBottomNavigationBar() {
        val button = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            // change for array iteration visibility
            controller2.visibility = View.VISIBLE
            controller1.visibility = View.GONE
        }

        button.setOnClickListener {
            controller2.visibility = View.GONE
            controller1.visibility = View.VISIBLE
        }
    }
}