package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.viewholder.ViewHolder1

/**
 * Created by albert.lukito on 16/11/20.
 */
class TestAdapter : ListAdapter<Pair<String, Fragment>, ViewHolder1>(DiffUtilCallback()) {

    override fun onBindViewHolder(holder: ViewHolder1, position: Int) {
        holder.bind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder1 {
        return ViewHolder1(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_1, parent, false),
            getItem(viewType),
            viewType + 1
        )
    }

    override fun getItemViewType(position: Int): Int = position

    class DiffUtilCallback : DiffUtil.ItemCallback<Pair<String, Fragment>>() {
        override fun areItemsTheSame(
            oldItem: Pair<String, Fragment>,
            newItem: Pair<String, Fragment>
        ): Boolean = oldItem.hashCode() == newItem.hashCode()

        override fun areContentsTheSame(
            oldItem: Pair<String, Fragment>,
            newItem: Pair<String, Fragment>
        ): Boolean = oldItem == newItem
    }

}
