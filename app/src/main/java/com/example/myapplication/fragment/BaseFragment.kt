package com.example.myapplication.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.myapplication.R


/**
 * Created by albert.lukito on 16/11/20.
 */

abstract class BaseFragment(@LayoutRes private val res: Int) : Fragment() {

    private var count = 0
    private var tv: TextView? = null
    var wasLoadData = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("asdasd", "onCreate: ${this::class.java.simpleName}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(res, container, false)
        tv = view.findViewById(R.id.tv_text)
        arguments?.let {
            tv?.text = "${this.javaClass.simpleName} - ${it.getString("content", "")}"
        }
        return view
    }

    fun setContent(uniqueId: String) {
        if (count < 2) {
            count += 1
            tv?.text = "${this.javaClass.simpleName} - $uniqueId: $count"
        }
    }

    fun loadData(){
        if (!wasLoadData){
            tv?.text = "Load Data"
            wasLoadData = true
        }
    }

}

class Fragment1 : BaseFragment(R.layout.fragment_1)
class Fragment2 : BaseFragment(R.layout.fragment_2)
class Fragment3 : BaseFragment(R.layout.fragment_3)
class Fragment4 : BaseFragment(R.layout.fragment_4)
class Fragment5 : BaseFragment(R.layout.fragment_5)
class Fragment6 : BaseFragment(R.layout.fragment_6)
class Fragment7 : BaseFragment(R.layout.fragment_7)
class Fragment8 : BaseFragment(R.layout.fragment_8)