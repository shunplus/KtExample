package com.shgbit.ktexample.ui

import android.content.Context
import com.shgbit.ktexample.R
import com.shgbit.ktexample.base.BaseActivity

/**
 * @author xushun on  2020/4/24 16:31.
 * Email：shunplus@163.com
 * Des：
 */
class NewsMoreActivity : BaseActivity() {
    lateinit var mContext: Context
    override fun getLayoutId(): Int {

        return R.layout.news_more_activity_layout
    }

    override fun initView() {
        mContext = this
        TODO("Not yet implemented")
    }

    override fun initData() {
        TODO("Not yet implemented")
    }
}