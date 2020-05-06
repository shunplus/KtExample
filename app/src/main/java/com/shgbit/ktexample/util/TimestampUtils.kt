package com.shgbit.ktexample.util

import java.text.ParsePosition
import java.text.SimpleDateFormat

/**
 * @author xushun on  2020/4/30 15:37.
 * Email：shunplus@163.com
 * Des：
 */
class TimestampUtils {

    companion object {

        /**
         * 转化为long
         */
        fun transToTimeStamp(date: String): Long {
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date, ParsePosition(0)).time
        }


        /**
         * 转化为 string类型时间
         */
        fun transToString(time: Long): String {
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time)
        }


        /**
         * 不同格式互相转化
         */
        fun tranStringToString(oldType: String, newType: String, strTime: String): String {

            var tanm = SimpleDateFormat(oldType).parse(strTime)

            return SimpleDateFormat(newType).format(tanm)
        }

    }
}