package com.example.admin.myapplication.View

import android.support.v4.app.FragmentManager
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

import com.example.admin.myapplication.Contact
import com.example.admin.myapplication.Model.InfoBean
import com.example.admin.myapplication.Presenter.MainPresenter
import com.example.admin.myapplication.Presenter.RecyclerViewAdapter
import com.example.admin.myapplication.R

class MainActivity : AppCompatActivity(), Contact.MainView {
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private val mainPresenter = MainPresenter(this)
    private val infoBean: InfoBean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initId()
        getData()
        refresh()
    }

    override fun initId() {
        swipeRefreshLayout = findViewById(R.id.SRL)
    }

    override fun initRV(infoBean: InfoBean?) {
        recyclerView = findViewById(R.id.RV)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        if (infoBean != null) {
            recyclerViewAdapter = RecyclerViewAdapter(infoBean)
            recyclerView!!.adapter = recyclerViewAdapter
            recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                    if (linearLayoutManager!!.itemCount - recyclerView.childCount <= linearLayoutManager.findFirstVisibleItemPosition()) {
                        mainPresenter.getBeforeData(recyclerViewAdapter!!.date)
                    }
                }
            })
        }
    }

    override fun getData() {
        mainPresenter.getLatestData()
    }

    override fun refresh() {
        swipeRefreshLayout!!.setOnRefreshListener {
            recyclerView = null
            recyclerViewAdapter = null
            getData()
            Toast.makeText(this, "刷新成功！", Toast.LENGTH_SHORT).show()
            swipeRefreshLayout!!.isRefreshing = false
        }
    }

    override fun loadMore(infoBean: InfoBean) {
        recyclerViewAdapter!!.update(infoBean)
    }

    override fun getSupportFragmentManager(): FragmentManager {
        return super.getSupportFragmentManager()
    }
}
