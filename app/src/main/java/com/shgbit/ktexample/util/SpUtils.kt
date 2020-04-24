package com.shgbit.ktexample.util

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shgbit.ktexample.app.HobbyApplication
import java.util.*

/**
 * @author xushun on  2020/4/4 13:50.
 * Email：shunplus@163.com
 * Des：
 */
object SpUtils {
    private val SHARE_KEY_UPDATE_DEMO = "share_key_update_demo"
    private var sp: SharedPreferences? = null

    /**
     * 写入boolean变量至sp中
     *
     * @param key   存储节点名称
     * @param value 存储节点的值
     */
    fun putBoolean(key: String?, value: Boolean) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        sp!!.edit().putBoolean(key, value).apply()
    }

    /**
     * 读取boolean标示从sp中
     *
     * @param key      存储节点名称
     * @param defValue 没有此节点默认值
     * @return 默认值或者此节点读取到的结果
     */
    fun getBoolean(key: String?, defValue: Boolean): Boolean {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        return sp!!.getBoolean(key, defValue)
    }

    /**
     * 写入String变量至sp中
     *
     * @param key   存储节点名称
     * @param value 存储节点的值
     */
    fun putString(key: String?, value: String?) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp =HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        sp!!.edit().putString(key, value).apply()
    }

    /**
     * 读取String标示从sp中
     *
     * @param key      存储节点名称
     * @param defValue 没有此节点默认值
     * @return 默认值或者此节点读取到的结果
     */
    fun getString(key: String?, defValue: String?): String? {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        return sp!!.getString(key, defValue)
    }


    /**
     * 写入int变量至sp中
     *
     * @param key   存储节点名称
     * @param value 存储节点的值
     */
    fun putInt(key: String?, value: Int) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        sp!!.edit().putInt(key, value).apply()
    }

    /**
     * 读取long标示从sp中
     *
     * @param key      存储节点名称
     * @param defValue 没有此节点默认值
     * @return 默认值或者此节点读取到的结果
     */
    fun getLong(key: String?, defValue: Long): Long {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        return sp!!.getLong(key, defValue)
    }


    /**
     * 写入long变量至sp中
     *
     * @param key   存储节点名称
     * @param value 存储节点的值
     */
    fun putLong(key: String?, value: Long) {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        sp!!.edit().putLong(key, value).apply()
    }

    /**
     * 读取int标示从sp中
     *
     * @param key      存储节点名称
     * @param defValue 没有此节点默认值
     * @return 默认值或者此节点读取到的结果
     */
    fun getInt(key: String?, defValue: Int): Int {
        //(存储节点文件名称,读写方式)
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        return sp!!.getInt(key, defValue)
    }

    /**
     * 从sp中移除指定节点
     *
     * @param key 需要移除节点的名称
     */
    fun remove(key: String?) {
        if (sp == null) {
            sp = HobbyApplication.mContext
                .getSharedPreferences(SHARE_KEY_UPDATE_DEMO, Context.MODE_PRIVATE)
        }
        sp!!.edit().remove(key).apply()
    }




}