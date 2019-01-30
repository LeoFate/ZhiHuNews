package com.example.admin.myapplication.Presenter

import android.content.Intent
import android.icu.text.IDNA
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.example.admin.myapplication.Model.InfoBean
import com.example.admin.myapplication.MyApplication
import com.example.admin.myapplication.R
import com.example.admin.myapplication.View.Banner
import com.example.admin.myapplication.View.MainActivity
import com.example.admin.myapplication.View.WebActivity

import java.util.ArrayList
import java.util.LinkedList
import java.util.Queue

class RecyclerViewAdapter(infoBean: InfoBean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val BANNER_TYPE = 1
    private val DATE_TYPE = 2
    private val MAIN_TYPE = 3
    private val mainList = ArrayList<Any>()
    private val topList = ArrayList<InfoBean.TopStoriesBean>()
    private val bannerList = ArrayList<Banner>()
    private val dateList = LinkedList<String>()
    private val viewPagerAdapter: ViewPagerAdapter? = null

    val date: String
        get() = dateList.element()

    init {
        mainList.add("今日热闻")
        mainList.addAll(infoBean.stories!!)
        dateList.add(infoBean.date!!)
        topList.addAll(infoBean.top_stories!!)
        for (i in topList.indices) {
            bannerList.add(Banner.getBannerInstance(topList[i].image!!))
        }
    }

    fun update(infoBean: InfoBean) {//用来呼应下拉加载，达到在同一个对象中更新数据目的
        mainList.add(infoBean.date!!)
        mainList.addAll(infoBean.stories!!)
        dateList.add(infoBean.date!!)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0)
            BANNER_TYPE
        else if (mainList[position - 1] is String)
            DATE_TYPE
        else
            MAIN_TYPE
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        var viewHolder: RecyclerView.ViewHolder? = null
        when (i) {
            BANNER_TYPE -> viewHolder = BannerHolder(
                    LayoutInflater.from(MyApplication.context).inflate(R.layout.rv_banner, viewGroup, false)
            )
            MAIN_TYPE -> viewHolder = MainHolder(
                    LayoutInflater.from(MyApplication.context).inflate(R.layout.rv_main, viewGroup, false)
            )
            DATE_TYPE -> viewHolder = DateHolder(
                    LayoutInflater.from(MyApplication.context).inflate(R.layout.rv_date, viewGroup, false)
            )
        }
        return viewHolder!!
    }


    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        when (viewHolder.itemViewType) {
            BANNER_TYPE -> {
                val bannerHolder = viewHolder as BannerHolder
                bannerHolder.viewPager.adapter = ViewPagerAdapter(MainActivity().supportFragmentManager, bannerList)
                bannerHolder.itemView.setOnClickListener { v ->
                    val intent = Intent(MyApplication.context, WebActivity::class.java)
                    intent.putExtra("id", topList[i].id)
                    MyApplication.context!!.startActivity(intent)
                }
            }
            MAIN_TYPE -> {
                val mainHolder = viewHolder as MainHolder
                val storyBean = mainList[i - 1] as InfoBean.StoriesBean
                mainHolder.title.text = storyBean.title
                Glide.with(MyApplication.context!!)
                        .load(storyBean.images!![0])
                        .into(mainHolder.image)
                mainHolder.itemView.setOnClickListener { v ->
                    val intent = Intent(MyApplication.context, WebActivity::class.java)
                    intent.putExtra("id", storyBean.id)
                    MyApplication.context!!.startActivity(intent)
                }
            }
            DATE_TYPE -> {
                val dateHolder = viewHolder as DateHolder
                dateHolder.date.text = mainList[i - 1] as String
            }
        }
    }

    override fun getItemCount(): Int {
        return mainList.size + 1
    }

    internal inner class BannerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var viewPager: ViewPager

        init {
            viewPager = itemView.findViewById<View>(R.id.ViewPager) as ViewPager
        }
    }

    internal inner class DateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var date: TextView

        init {
            date = itemView.findViewById<View>(R.id.rv_date_text) as TextView
        }
    }

    internal inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ImageView

        init {
            title = itemView.findViewById<View>(R.id.rv_main_text) as TextView
            image = itemView.findViewById<View>(R.id.rv_main_image) as ImageView
        }
    }
}
