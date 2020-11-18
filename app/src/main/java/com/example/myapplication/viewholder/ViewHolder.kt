package com.example.myapplication.viewholder

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.fragment.*
import java.text.FieldPosition

/**
 * Created by albert.lukito on 16/11/20.
 */

abstract class BaseViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private var uniqueId = ""

    abstract val fragmentContainerResId: Int
    abstract fun createFragmentInstance(): BaseFragment
    abstract fun ifDesiredFragmentIsCorrect(fragment: Fragment): Boolean

    fun bind(uniqueId: String, position: Int) {
        Log.d("asdasd", this::class.java.simpleName + " bind")
        this.uniqueId = uniqueId

        val fragmentManager = (view.context as? AppCompatActivity)?.supportFragmentManager
        /*if (fragmentManager?.fragments?.isNotEmpty() == true) {
            (fragmentManager.fragments[position] as BaseFragment).let {
                if (ifDesiredFragmentIsCorrect(it)) {
                    it.setContent(uniqueId)
                }
            }
        }*/
        /*(fragmentManager?.findFragmentByTag(this::class.java.simpleName) as? BaseFragment)?.let {
            it.setContent(uniqueId)
        }*/
    }

    fun attachFragmentToContainer() {
        val fragmentManager = (view.context as? AppCompatActivity)?.supportFragmentManager
        if (fragmentManager?.findFragmentByTag(uniqueId) == null) {
            val fragment = createFragmentInstance().apply {
                arguments = Bundle().apply {
                    putString("content", uniqueId)
                }
            }
            fragmentManager?.beginTransaction()?.add(fragmentContainerResId, fragment, uniqueId)?.commit()
        } else {
            val fragment = fragmentManager.findFragmentByTag(uniqueId)
            fragment?.let {
                fragmentManager.beginTransaction().replace(fragmentContainerResId, it, uniqueId).commit()
            }
        }
    }

}

class ViewHolder1(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_1
    override fun createFragmentInstance() = Fragment1()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment1
}

class ViewHolder2(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_2
    override fun createFragmentInstance() = Fragment2()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment2
}

class ViewHolder3(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_3
    override fun createFragmentInstance() = Fragment3()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment3
}

class ViewHolder4(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_4
    override fun createFragmentInstance() = Fragment4()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment4
}

class ViewHolder5(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_5
    override fun createFragmentInstance() = Fragment5()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment5
}

class ViewHolder6(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_6
    override fun createFragmentInstance() = Fragment6()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment6
}

class ViewHolder7(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_7
    override fun createFragmentInstance() = Fragment7()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment7
}

class ViewHolder8(view: View) : BaseViewHolder(view) {
    override val fragmentContainerResId: Int = R.id.fragment_container_8
    override fun createFragmentInstance() = Fragment8()
    override fun ifDesiredFragmentIsCorrect(fragment: Fragment) = fragment is Fragment8
}
