package com.shgbit.ktexample.bean

/**
 * @author xushun on  2020/3/28 15:13.
 * Email：shunplus@163.com
 * Des：
 */
data class CourtBean(
    var `data`: List<Data>,
    var errorCode: String,
    var exception: String,
    var iserror: Boolean,
    var message: String
)

data class Data(
    var id: String,
    var mobile: String,
    var name: String,
    var online: Boolean,
    var `open`: Boolean,
    var pId: String,
    var phone: String
)