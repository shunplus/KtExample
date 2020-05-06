package com.shgbit.ktexample.util

import android.content.res.Resources

/**
 * @author xushun on  2020/3/30 16:27.
 * Email：shunplus@163.com
 * Des：工具类
 */
object HobbyUtils {

    fun dp2px(resources: Resources, dp: Float): Int {
        val scale = resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }
}