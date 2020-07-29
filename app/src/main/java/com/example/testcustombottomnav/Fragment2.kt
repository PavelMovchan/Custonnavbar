package com.example.testcustombottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Fragment2 : Fragment() {
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment2, container, false)
        this.rootView = rootView
        val button1 = rootView.findViewById<Button>(R.id.button2)
        val fm: FragmentManager = requireActivity().supportFragmentManager
        val instanceId = fm.fragments.count().toString()
        button1.setOnClickListener {
            val newFragment = PushedFragment()
            newFragment.containerIdForPush = R.id.search_nav_host
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.add(R.id.search_nav_host, newFragment).addToBackStack(instanceId)
            transaction.commit()

//            val pushedFragment = PushedFragment()
//            requireActivity().supportFragmentManager.beginTransaction().add(R.id.fragmnt1Container, pushedFragment).commit()
        }
        return this.rootView
    }
}