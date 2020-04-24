package com.shgbit.ktexample.app

import android.app.Application
import android.content.Context
import com.shgbit.ktexample.network.RxRestClient
import kotlin.properties.Delegates

/**
 * @author xushun on  2020/3/22 23:12.
 * Email：shunplus@163.com
 * Des：
 */
class HobbyApplication :Application() {

    companion object{
        lateinit var mContext:Context
        var userId:String =""
        var instance:HobbyApplication by Delegates.notNull<HobbyApplication>()
    }
    override fun onCreate() {
        super.onCreate()
        mContext=applicationContext
        instance=this
        //初始化retroft请求任务
       RxRestClient.instance.creatRetrofit()
    }
}