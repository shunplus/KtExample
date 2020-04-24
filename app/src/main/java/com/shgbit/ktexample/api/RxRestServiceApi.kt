package com.shgbit.ktexample.api

import com.shgbit.ktexample.bean.BannerDataBean
import com.shgbit.ktexample.bean.CourtBean
import com.shgbit.ktexample.bean.LoginBean
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*

/**
 * @author xushun on  2020/3/19 23:50.
 * Email：shunplus@163.com
 * Des：请求接口api
 */
interface RxRestServiceApi {

    /**
     * 传入请求接口的方式
     */
    @FormUrlEncoded
    @POST
    fun post(@Url url:String,@FieldMap map:WeakHashMap<String,Objects>):Observable<String>

    /**
     * 登录接口
     */
    @POST("/iexe/a/login")
    @FormUrlEncoded
    fun login(@Field ("userCode")username:String,
              @Field("upw")password:String,
              @Field("crop")court:String,
              @Field ("device")device:String):Observable<LoginBean>


    /**
     * 获取法院列表
     */
    @POST("/iexe/a/sys/office/getCourtList")
    @FormUrlEncoded
    fun getCourtList(@Field ("id")id:String):Observable<CourtBean>


    /**
     * 获取新闻轮播图
     */
    @POST("/iexe/enController/getIndexNewsDataForApp")
    @FormUrlEncoded
    fun getBannerList(@Field ("userId")id:String):Observable<BannerDataBean>

}