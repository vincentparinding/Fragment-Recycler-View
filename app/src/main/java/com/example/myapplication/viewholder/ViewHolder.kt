package com.example.myapplication.viewholder

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

/**
 * Created by albert.lukito on 16/11/20.
 */

class ViewHolder1(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(pair: Pair<String, Fragment>, idContainer: Int) {
        val container = view.findViewById<FragmentContainerView>(R.id.fragment_container_1)
        val fragmentManager = (view.context as? AppCompatActivity)?.supportFragmentManager
        container?.id = idContainer
        val frg = fragmentManager?.findFragmentById(idContainer)
        if (frg == null) {
            fragmentManager?.beginTransaction()?.add(idContainer, pair.second, pair.first)
                ?.commit()
        }
    }
}