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


class PushedFragment : Fragment() {
    companion object {
        var info = 0
    }

    var containerIdForPush = -1 // -1 not init
    private lateinit var rootView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.pushed_fragment, container, false)
        this.rootView = rootView
        val button = rootView.findViewById<Button>(R.id.popbutton)
        val pushnew = rootView.findViewById<Button>(R.id.pushnew)
        val textView = rootView.findViewById<TextView>(R.id.textView2)
        var text = "from profile";
        if (containerIdForPush == R.id.search_nav_host) {
            text = "from search";
        }

        textView.text = info.toString() + text
        button.setOnClickListener {
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.remove(this) // do not use pop, cause it can revert last commit from other fragment container
            transaction.commit()
            info -= 1
            info = maxOf(0, info)
        }

        pushnew.setOnClickListener {
            val newFragment = PushedFragment()
            newFragment.containerIdForPush = containerIdForPush
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.add(containerIdForPush, newFragment).addToBackStack(null)
            transaction.commit()
            info += 1
        }
        return this.rootView
    }
}