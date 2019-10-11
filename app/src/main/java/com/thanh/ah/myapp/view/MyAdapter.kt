package com.thanh.ah.myapp.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.thanh.ah.myapp.R
import com.thanh.ah.myapp.base.BaseItemHolder

class MyAdapter() :
    RecyclerView.Adapter<BaseItemHolder<*>>() {

    private var data = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemHolder<*> {

        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message, parent, false)
        return MyItemHolder(view)
    }

    override fun onBindViewHolder(holder: BaseItemHolder<*>, position: Int) {
        val element = data[position]
        when (holder) {
            is MyItemHolder -> holder.bind(element)
        }
    }


    fun addItems(newItem: List<String>) {

        data.addAll(newItem)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
