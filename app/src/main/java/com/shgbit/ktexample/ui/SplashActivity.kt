package com.shgbit.ktexample.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.util.Log
import com.shgbit.ktexample.api.RxRestServiceApi
import com.shgbit.ktexample.app.HobbyApplication
import com.shgbit.ktexample.network.NewworkScheduler
import com.shgbit.ktexample.network.RxRestClient
import com.shgbit.ktexample.util.PLog
import com.shgbit.ktexample.util.SpUtil
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindUntilEvent

/**
 * @author xushun on  2020/3/28 21:35.
 * Email：shunplus@163.com
 * Des：
 */
class SplashActivity:RxAppCompatActivity(){
    private var cookie: String by SpUtil("Cookie", "")
    private var courtId by SpUtil("courtId", "")
    private var username by SpUtil("username", "")
    private var pasword by SpUtil("pasword", "")

    // 将常量放入这里
    companion object {

        // 正常跳转到登录界面 常量 防止以后增加业务逻辑
        val MSG_LAUNCH : Int = 0
        val MSG_MAINACTIVITY : Int = 1

        // 延时时间
        val SLEEP_TIME = 50
    }
    private val mHandler = SplashHandle(this)
    val runnable = Runnable {
        kotlin.run {
            val message = mHandler.obtainMessage(MSG_LAUNCH)
            mHandler.sendMessage(message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash)

    }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()

        val start = System.currentTimeMillis()

        /*
        这里计算了两个时间
        两个时间间可以放入判断条件：是否需要自动登录等
         */

        var costTime = System.currentTimeMillis() - start

        val left = SLEEP_TIME - costTime
        if (courtId!!.isNotBlank()&&username!!.isNotBlank()&&pasword!!.isNotBlank()){
            cookie=""
            RxRestClient.instance.getService(RxRestServiceApi::class.java).login(username,pasword,courtId,"1212121212")
                .compose(NewworkScheduler.compose())
                .bindUntilEvent(this, ActivityEvent.DESTROY)
                .subscribe(
                    {
                            t->
                        run {
                            HobbyApplication.userId=t.data.user.id
                            val message = mHandler.obtainMessage(MSG_MAINACTIVITY)
                            mHandler.sendMessage(message)
                        }
                    },
                    {
                            e->  mHandler.postDelayed(runnable, if(left > 0) left else 0)
                        Log.e(PLog.TAG," failure $e")
                    }
                )



        }else{
            // kotlin中取消了java中的三目运算，换成if...else...
            mHandler.postDelayed(runnable, if(left > 0) left else 0)
        }

    }

    private class SplashHandle(cls : SplashActivity) : UIHandler<SplashActivity>(cls) {

        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            val activity = ref?.get()
            if (null != activity){

                if (activity.isFinishing)
                    return

                when(msg?.what){

                    // 正常跳转到登录界面
                    MSG_LAUNCH -> {
                        activity.startActivity(Intent(activity, LoginActivity::class.java))
                        activity.finish()
                    }

                    // 正常跳转到登录界面
                    MSG_MAINACTIVITY -> {
                        activity.startActivity(Intent(activity, MainActivity::class.java))
                        activity.finish()
                    }
                }
            }
        }
    }
}