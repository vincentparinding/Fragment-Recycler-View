package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 *  RecyclerView + Fragment
 * */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rv_test).let {
            val adapter = TestAdapter()
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            adapter.submitList(listOf(
                Pair("unique_1", 0),
                Pair("unique_2", 1),
                Pair("unique_3", 2),
                Pair("unique_4", 3),
                Pair("unique_5", 4),
                Pair("unique_6", 5),
                Pair("unique_7", 6),
                Pair("unique_8", 7),
                Pair("unique_1_2", 0),
                Pair("unique_2_2", 1),
                Pair("unique_3_2", 2)
            ))
        }
    }

}