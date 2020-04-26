package com.shgbit.ktexample.ui

import android.content.Context
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import com.shgbit.ktexample.R
import com.shgbit.ktexample.app.Constants
import com.shgbit.ktexample.base.BaseActivity
import com.shgbit.ktexample.util.PLog
import kotlinx.android.synthetic.main.activity_news_details_layout.*

/**
 * @author xushun on  2020/4/24 10:39.
 * Email：shunplus@163.com
 * Des：
 */
class NewsDetailsActivity : BaseActivity() {
    lateinit var mContext: Context
    var loadUrl: String = ""
    override fun getLayoutId(): Int {
       return R.layout.activity_news_details_layout
    }

    override fun initView() {
        mContext = this
        topView.setFinishActivity(this)
        if (intent.hasExtra("loadUrl")) {
            loadUrl =
                Constants.HOST + "iexe/enController/viewNews?newsId=" + intent.getStringExtra("loadUrl")
        }
        val settings: WebSettings = wv_news_content.getSettings()
        settings.javaScriptEnabled = true
        settings.builtInZoomControls = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        // 关键点
        // 关键点
        settings.useWideViewPort = true
        // 允许访问文件
        // 允许访问文件
        settings.allowFileAccess = true
        // 支持缩放
        // 支持缩放
        settings.setSupportZoom(true)

//        wv_news_content.addJavascriptInterface(JavascriptInterface(this), "imagelistner")

        wv_news_content.setWebViewClient(object : WebViewClient() {
            // 网页跳转
            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return super.shouldOverrideUrlLoading(view, url)
            }

            // 网页加载结束
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)

                // html加载完成之后，添加监听图片的点击js函数
//                addImageClickListner()
            }
        })


        wv_news_content.setWebChromeClient(object : WebChromeClient() {
            /*** 视频播放相关的方法  */
            override fun getVideoLoadingProgressView(): View? {
                val frameLayout = FrameLayout(mContext)
                frameLayout.layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                return frameLayout
            }

            override fun onShowCustomView(view: View, callback: CustomViewCallback) {
//                showCustomView(view, callback)
            }

            override fun onHideCustomView() {
//                hideCustomView()
            }
        })
        wv_news_content.loadUrl(loadUrl)
        PLog.i(PLog.TAG, "loadUrl $loadUrl ")
    }

    override fun initData() {

    }
}