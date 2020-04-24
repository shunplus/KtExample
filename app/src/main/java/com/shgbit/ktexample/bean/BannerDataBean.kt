package com.shgbit.ktexample.bean

/**
 * @author xushun on  2020/4/23 22:32.
 * Email：shunplus@163.com
 * Des：
 */
data class BannerDataBean (
    var `data`: List<BannerData>,
    var errorCode: String,
    var exception: String,
    var iserror: Boolean,
    var message: String
)

data class BannerData(
    var FRONT_COVER_IMAGE: String,
    var ID: String
)