package com.shgbit.ktexample.util

import android.content.Context
import android.os.Handler
import android.widget.Toast
import com.shgbit.ktexample.app.HobbyApplication

/**
 * @author xushun on  2020/4/4 13:12.
 * Email：shunplus@163.com
 * Des：
 */
object CustomToast {
    private var mToast: Toast? = null
    private val mHandler = Handler()
    private val r = Runnable { mToast!!.cancel() }

    fun showToast(text: String?) {
        showToast(HobbyApplication.mContext, text, Toast.LENGTH_SHORT)
    }

    fun showToastLong(text: String?) {
        showToast(HobbyApplication.mContext, text, Toast.LENGTH_LONG)
    }

    fun showToast(mContext: Context, text: String?) {
        showToast(mContext, text, Toast.LENGTH_SHORT)
    }

    fun showToast(mContext: Context, resId: Int) {
        showToast(mContext, resId, Toast.LENGTH_SHORT)
    }

    var appContext: Context = HobbyApplication.mContext
    fun showToast(
        mContext: Context,
        text: String?,
        duration: Int
    ) {
        val appContext = mContext.applicationContext
        //        mHandler.removeCallbacks(r);
//        if (mToast != null)
//            mToast.setText(text);
//        else
//            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
//        mHandler.postDelayed(r, duration);
        if (mToast != null) mToast!!.setText(text) else mToast =
            Toast.makeText(appContext, text, duration)
        mToast!!.show()
    }

    fun showToast(mContext: Context, resId: Int, duration: Int) {
        showToast(mContext, mContext.resources.getString(resId), duration)
    }

    /**
     * 多次点击 多次弹
     *
     * @param text
     */
    fun showToastMultipleClicks(text: String?) {
        if (mToast != null) {
            mToast!!.cancel()
            mToast = Toast.makeText(HobbyApplication.mContext, text, Toast.LENGTH_SHORT)
            mToast?.show()
        } else {
            mToast = Toast.makeText(HobbyApplication.mContext, text, Toast.LENGTH_SHORT)
            mToast?.show()
        }
    }

    /**
     * des:
     *
     * @author xushun
     * @time 2019/12/3 14:41
     */
//    fun showToastOnThread(text: String?) {
//        AppUtils.runOnUIThread(Runnable { showToast(text) })
//    }
}