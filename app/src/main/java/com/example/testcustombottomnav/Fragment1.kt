package com.example.testcustombottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class Fragment1 : Fragment() {
    var count = 0
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment1, container, false)
        this.rootView = rootView
        count += 1
        val textView = rootView.findViewById<TextView>(R.id.textView)
        textView.text = count.toString()

        val button1 = rootView.findViewById<Button>(R.id.button1)
        val fm: FragmentManager = requireActivity().supportFragmentManager
        val instanceId = fm.fragments.count().toString()
        button1.setOnClickListener {
            val newFragment = PushedFragment()
            newFragment.containerIdForPush = R.id.profile_nav_host
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.add(R.id.profile_nav_host, newFragment).addToBackStack(instanceId)
            transaction.commit()
        }

        return this.rootView
    }
}