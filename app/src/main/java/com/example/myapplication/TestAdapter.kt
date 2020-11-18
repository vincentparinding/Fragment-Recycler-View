package com.example.myapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.viewholder.*

/**
 * Created by albert.lukito on 16/11/20.
 */
class TestAdapter: ListAdapter<Pair<String, Int>, BaseViewHolder>(DiffUtilCallback()) {

    companion object {
        const val TYPE_1 = 0
        const val TYPE_2 = 1
        const val TYPE_3 = 2
        const val TYPE_4 = 3
        const val TYPE_5 = 4
        const val TYPE_6 = 5
        const val TYPE_7 = 6
        const val TYPE_8 = 7
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        Log.d("asdasd", "onbind: $position")
        holder.bind(getItem(position).first, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType) {
            TYPE_1 -> ViewHolder1(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_1, parent, false))
            TYPE_2 -> ViewHolder2(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_2, parent, false))
            TYPE_3 -> ViewHolder3(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_3, parent, false))
            TYPE_4 -> ViewHolder4(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_4, parent, false))
            TYPE_5 -> ViewHolder5(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_5, parent, false))
            TYPE_6 -> ViewHolder6(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_6, parent, false))
            TYPE_7 -> ViewHolder7(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_7, parent, false))
            else -> ViewHolder8(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_8, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).second) {
            0 -> TYPE_1
            1 -> TYPE_2
            2 -> TYPE_3
            3 -> TYPE_4
            4 -> TYPE_5
            5 -> TYPE_6
            6 -> TYPE_7
            else -> TYPE_8
        }
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder) {
        Log.d("asdasd", "onViewAttachedToWindow: ${holder.javaClass.simpleName}")
        /*if (holder is ViewHolder1) {
            (holder.view.context as? AppCompatActivity)?.supportFragmentManager
                ?.beginTransaction()?.replace(holder.getFrameId(), holder.createFragmentInstance())?.commit()
        }*/
        holder.attachFragmentToContainer()
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        Log.d("asdasd", "onViewDetachedFromWindow: " + holder::class.java)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        Log.d("asdasd", "-- onViewRecycled: " + holder::class.java.simpleName)
        super.onViewRecycled(holder)
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Pair<String, Int>>() {
        override fun areItemsTheSame(oldItem: Pair<String, Int>, newItem: Pair<String, Int>): Boolean = oldItem.hashCode() == newItem.hashCode()
        override fun areContentsTheSame(oldItem: Pair<String, Int>, newItem: Pair<String, Int>): Boolean = oldItem == newItem
    }

}
