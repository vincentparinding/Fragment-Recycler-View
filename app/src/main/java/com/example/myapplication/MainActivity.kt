package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.fragment.*

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
            adapter.submitList(
                listOf(
                    Pair("unique_1", Fragment1().apply {
                        arguments = Bundle().apply { putString("content", "unique_1") }
                    }),
                    Pair("unique_2", Fragment2().apply {
                        arguments = Bundle().apply { putString("content", "unique_2") }
                    }),
                    Pair("unique_3", Fragment3().apply {
                        arguments = Bundle().apply { putString("content", "unique_3") }
                    }),
                    Pair("unique_4", Fragment4().apply {
                        arguments = Bundle().apply { putString("content", "unique_4") }
                    }),
                    Pair("unique_5", Fragment5().apply {
                        arguments = Bundle().apply { putString("content", "unique_5") }
                    }),
                    Pair("unique_6", Fragment6().apply {
                        arguments = Bundle().apply { putString("content", "unique_6") }
                    }),
                    Pair("unique_7", Fragment7().apply {
                        arguments = Bundle().apply { putString("content", "unique_7") }
                    }),
                    Pair("unique_8", Fragment8().apply {
                        arguments = Bundle().apply { putString("content", "unique_8") }
                    }),
                    Pair("unique_1_2", Fragment1().apply {
                        arguments = Bundle().apply { putString("content", "unique_9") }
                    }),
                    Pair("unique_2_2", Fragment2().apply {
                        arguments = Bundle().apply { putString("content", "unique_10") }
                    }),
                    Pair("unique_3_2", Fragment3().apply {
                        arguments = Bundle().apply { putString("content", "unique_11") }
                    })
                )
            )
        }
    }

}