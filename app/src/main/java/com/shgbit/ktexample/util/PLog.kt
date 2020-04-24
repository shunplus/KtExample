package com.shgbit.ktexample.util

import android.util.Log

/**
 * @author xushun on  2020/3/30 21:53.
 * Email：shunplus@163.com
 * Des：log工具类
 */
object PLog {
    val TAG="Hobby";
    val OKHTTP="OKHTTP";

    fun i(tag: String?, msg: String?) {
        var msg = msg
        if (tag == null || tag.length == 0 || msg == null || msg.length == 0
        ) return
        val segmentSize = 3 * 1024
        val length = msg.length.toLong()
        if (length <= segmentSize) { // 长度小于等于限制直接打印
            Log.i(tag, msg)
        } else {
            while (msg!!.length > segmentSize) { // 循环分段打印日志
                val logContent = msg.substring(0, segmentSize)
                msg = msg.replace(logContent, "")
                Log.i(tag, "------------------------------")
                Log.i(tag, logContent)
            }
            Log.i(tag, "------------------------------")
            Log.i(tag, msg) // 打印剩余日志
        }
    }
}