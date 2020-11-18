package com.example.myapplication.viewholder

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by adrianfikri on 18/11/20.
 */
class FragmentViewHolder(container: FrameLayout) : RecyclerView.ViewHolder(container) {



    fun getContainer(): FrameLayout = itemView as FrameLayout
}