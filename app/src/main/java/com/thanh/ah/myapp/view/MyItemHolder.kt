package com.thanh.ah.myapp.view

import android.view.View
import com.thanh.ah.myapp.base.BaseItemHolder
import kotlinx.android.synthetic.main.item_message.view.*

class MyItemHolder(val view: View) :

    BaseItemHolder<String>(view) {

    override fun bind(item: String) {

        view.tvMess.text = item
    }
}
