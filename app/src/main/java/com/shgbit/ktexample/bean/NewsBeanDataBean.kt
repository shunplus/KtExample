package com.shgbit.ktexample.bean

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * @author xushun on  2020/4/26 16:05.
 * Email：shunplus@163.com
 * Des：
 */
data class NewsBeanDataBean(
    var `data`: NewsBeanDataOne,
    var errorCode: String,
    var exception: String,
    var iserror: Boolean,
    var message: String
)

data class NewsBeanDataOne(
    var page: PageBean,
    var sortOrder: String,
    var sortType: String
)

data class PageBean(
    var count: Int,
    var emcount: Int,
    var firstResult: Int,
    var html: String,
    var last: Int,
    var list: List<PageData>,
    var maxResults: Int,
    var pageIndex: Int,
    var pageSize: Int
)

data class PageData(
    var content: String,
    var frontCoverImage: String,
    var id: String,
    var jianJie: String,
    var publishDate: String,
    var readCount: String,
    var title: String,
    var top: String,
    var type: String, override var itemType: Int
) :MultiItemEntity