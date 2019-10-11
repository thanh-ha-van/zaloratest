package com.thanh.ah.myapp.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseItemHolder<in T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}
