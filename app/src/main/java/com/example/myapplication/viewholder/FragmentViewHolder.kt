package com.example.myapplication.viewholder

import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by adrianfikri on 18/11/20.
 */
class FragmentViewHolder(container: FrameLayout) : RecyclerView.ViewHolder(container) {


    fun getContainer(): FrameLayout = itemView as FrameLayout
}