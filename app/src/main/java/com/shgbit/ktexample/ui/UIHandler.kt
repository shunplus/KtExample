package com.shgbit.ktexample.ui

import android.os.Handler
import java.lang.ref.WeakReference

/**
 * @author xushun on  2020/3/28 21:42.
 * Email：shunplus@163.com
 * Des：
 */
open class UIHandler<T>(cls: T) : Handler() {

    protected var ref: WeakReference<T>? = null

    init {
        ref = WeakReference(cls)
    }

    fun getRef(): T? {
        return if (ref != null) ref!!.get() else null
    }

}
