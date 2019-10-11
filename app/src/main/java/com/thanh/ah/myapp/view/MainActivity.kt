package com.thanh.ah.myapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.thanh.ah.myapp.R
import com.thanh.ah.myapp.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {


    // suppose to have full structure of MVP, clean architecture. But since it not require any of
    // that so i just simple make it View - Presenter
    // To see my projects that have structure, please go to:
    // https://github.com/thanhahvan1/WordBookProject - MVP
    // https://github.com/thanhahvan1/WardProject - MVP
    // https://github.com/thanhahvan1/Tik-Test - MVVM

    lateinit var mPresenter: MainPresenterImpl

    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainPresenterImpl(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvMess.layoutManager = layoutManager
        adapter = MyAdapter()
        rvMess.adapter = adapter
    }

    override fun onShowList(list: List<String>) {
        adapter.addItems(list)
    }
}
