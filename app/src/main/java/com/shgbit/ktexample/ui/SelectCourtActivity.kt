package com.shgbit.ktexample.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.shgbit.ktexample.R
import com.shgbit.ktexample.adapter.SelectAdapter
import com.shgbit.ktexample.api.RxRestServiceApi
import com.shgbit.ktexample.base.BaseActivity
import com.shgbit.ktexample.bean.Data
import com.shgbit.ktexample.network.NewworkScheduler
import com.shgbit.ktexample.network.RxRestClient
import com.shgbit.ktexample.util.PLog
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_select_layout.*
/**
 * @author xushun on  2020/3/30 16:23.
 * Email：shunplus@163.com
 * Des： 选择法院
 */
class SelectCourtActivity :BaseActivity(){
    lateinit var mContext: Context
    lateinit var data :MutableList<Data>
    lateinit var adapter:SelectAdapter
    override fun getLayoutId(): Int {
        return R.layout.activity_select_layout
    }

    override fun initView() {
        mContext=this
        topView.setFinishActivity(this)
    }

    override fun initData() {
        data= mutableListOf<Data>()
        adapter=SelectAdapter(R.layout.item_select_court,data)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(mContext)
        adapter.setOnItemClickListener(object: OnItemClickListener{
            override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                var dataIntent=Intent()
                dataIntent.putExtra("courtName",data.get(position).name)
                dataIntent.putExtra("courtId",data.get(position).id)
                setResult(Activity.RESULT_OK,dataIntent)
                finish()
            }
        })
        getCourt("0")
    }


    @SuppressLint("CheckResult")
    fun getCourt(id:String){
        RxRestClient.instance.getService(RxRestServiceApi::class.java).getCourtList(id)
            .compose(NewworkScheduler.compose())
            .bindUntilEvent(this,ActivityEvent.DESTROY)
            .subscribe(
                {
                        t->
                    run {
                        Log.d(PLog.TAG, " subscribe $t")
                        data.addAll(t.data)
                        adapter.notifyDataSetChanged()
                    }
                },
                {
                        e->Log.e(PLog.TAG," subscribe $e")
                }
            )
    }
}