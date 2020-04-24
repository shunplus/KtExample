package com.shgbit.ktexample.bean

/**
 * @author xushun on  2020/3/28 14:53.
 * Email：shunplus@163.com
 * Des：
 */
data class ResponseWrapper<out T> (val data:T/*,val errorCode:String,val iserror :String,val exception:String*/){
}