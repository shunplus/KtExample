package com.shgbit.ktexample.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Process
import android.util.Log
import android.view.View
import com.shgbit.ktexample.R
import com.shgbit.ktexample.adapter.ImageNetAdapter
import com.shgbit.ktexample.api.RxRestServiceApi
import com.shgbit.ktexample.app.HobbyApplication
import com.shgbit.ktexample.base.BaseActivity
import com.shgbit.ktexample.bean.BannerData
import com.shgbit.ktexample.network.NewworkScheduler
import com.shgbit.ktexample.network.RxRestClient
import com.shgbit.ktexample.util.PLog
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import com.youth.banner.config.BannerConfig
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.util.BannerUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    lateinit var mContext: Context
    lateinit var data :MutableList<BannerData>
    lateinit var  adapter :ImageNetAdapter
    companion object{
        val TAG="Hobby";
    }

    override fun getLayoutId(): Int=R.layout.activity_main
    override fun initView() {
        Log.d(TAG," initView " )
        mContext=this
        login_out.setOnClickListener(onClickListener)
        switch_account.setOnClickListener(onClickListener)
        tv_more_news.setOnClickListener(onClickListener)
        topView.setBackVisiable(View.GONE)
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setDelayTime(3000)
        data= arrayListOf();
        adapter = ImageNetAdapter( data,mContext);
        banner.adapter=adapter
        banner.setIndicator(CircleIndicator(mContext))
        banner.setIndicatorGravity(IndicatorConfig.Direction.CENTER)
        banner.setIndicatorMargins(
            IndicatorConfig.Margins(
                0, 0,
                BannerConfig.INDICATOR_MARGIN, BannerUtils.dp2px(12f).toInt()
            )
        )

        banner.setOnBannerListener { data, position ->
            var bannerData:BannerData= data as BannerData

            var intent = Intent(mContext, NewsDetailsActivity::class.java)
            intent.putExtra("loadUrl", (data as BannerData).ID)
            startActivity(intent)
           PLog.i(PLog.TAG," data ${bannerData.ID}")
        }
        banner.start()
    }

    override fun initData() {
        getBanner(  HobbyApplication.userId);
    }

    private val onClickListener= View.OnClickListener {
            view->
        Log.i(TAG," text = ")
        when(view.id){
            R.id.login_out ->{
                moveTaskToBack(true)
                Process.killProcess(Process.myPid())
                System.exit(1)
            }

            R.id.switch_account->{

                var intent= Intent(mContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            R.id.tv_more_news -> {
                
            }
        }
    }

    @SuppressLint("CheckResult")
    fun getBanner(userId:String){
        RxRestClient.instance.getService(RxRestServiceApi::class.java).getBannerList(userId)
            .compose(NewworkScheduler.compose())
            .bindUntilEvent(this, ActivityEvent.DESTROY)
            .subscribe(  {
                    t->
                run {
                    Log.d(PLog.TAG, " subscribe $t")
                    data.addAll(t.data)
                    adapter.notifyDataSetChanged()
                }
            },
                {
                        e->Log.e(PLog.TAG," subscribe $e")
                })
//            .subscribe(object: RxRestRespon<BannerDataBean>(mContext){
//                override fun onSucess(databean: BannerDataBean) {
//                    data.addAll(databean.data)
//                    adapter.notifyDataSetChanged()
//                }
//
//                override fun onFailure(statusCode: Int, apiError: ApiError) {
//                    Log.e(PLog.TAG," onFailure   $apiError ")
//                }
//            })



    }

}
