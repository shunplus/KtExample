package com.shgbit.ktexample.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.shgbit.ktexample.R
import com.shgbit.ktexample.adapter.NewsListAdapter
import com.shgbit.ktexample.api.RxRestServiceApi
import com.shgbit.ktexample.base.BaseActivity
import com.shgbit.ktexample.bean.PageData
import com.shgbit.ktexample.network.NewworkScheduler
import com.shgbit.ktexample.network.RxRestClient
import com.shgbit.ktexample.util.PLog
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_select_layout.*

/**
 * @author xushun on  2020/4/24 16:31.
 * Email：shunplus@163.com
 * Des：
 */
class NewsMoreActivity : BaseActivity() {
    lateinit var mContext: Context
    var pageIndex = 1
    var pageSize: Int = 10
    var lastPage: Int = 1
    lateinit var newsAdapter: NewsListAdapter
    lateinit var data: MutableList<PageData>
    override fun getLayoutId(): Int {

        return R.layout.news_more_activity_layout
    }

    override fun initView() {
        mContext = this
        topView.setFinishActivity(this)
        data = mutableListOf()
        newsAdapter = NewsListAdapter(data, mContext)
        recyclerView.adapter = newsAdapter
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        newsAdapter.setOnItemClickListener { adapter, view, position ->

            var intent = Intent(mContext, NewsDetailsActivity::class.java)
            intent.putExtra("loadUrl", data.get(position).id)
            startActivity(intent)
            var mHander = Handler()
            mHander.postDelayed(object : Runnable {
                override fun run() {
                    data.get(position).readCount =
                        (data.get(position).readCount.toInt() + 1).toString()
                    newsAdapter.notifyDataSetChanged()
                }
            }, 2000)
        }
    }

    override fun initData() {
        getNewsList(pageIndex, pageSize)
    }


    @SuppressLint("CheckResult")
    fun getNewsList(pageIndex: Int, pageSize: Int) {
        RxRestClient.instance.getService(RxRestServiceApi::class.java)
            .getMoreNewsList(pageIndex.toString(), pageSize.toString())
            .compose(NewworkScheduler.compose())
            .bindUntilEvent(this, ActivityEvent.DESTROY)
            .subscribe(
                { t ->
                    run {
                        data.addAll(t.data.page.list)

                        data.forEach {
                            it.itemType = it.type.toInt()
                        }
                        newsAdapter.notifyDataSetChanged()
                        Log.d(PLog.TAG, " subscribe $t")
                    }
                },
                { e ->
                    Log.e(PLog.TAG, " subscribe $e")
                }
            )
    }
}