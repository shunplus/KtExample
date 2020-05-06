package com.shgbit.ktexample.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.shgbit.ktexample.R
import com.shgbit.ktexample.app.Constants
import com.shgbit.ktexample.bean.PageData
import com.shgbit.ktexample.util.GlideUtils
import com.shgbit.ktexample.util.PLog
import com.shgbit.ktexample.util.TimestampUtils

/**
 * @author xushun on  2020/4/26 11:47.
 * Email：shunplus@163.com
 * Des：
 */
class NewsListAdapter(data: MutableList<PageData>, mContext: Context) :
    BaseMultiItemQuickAdapter<PageData, BaseViewHolder>(data) {

    var mContext: Context

    init {
        this.mContext = mContext
        //新闻类型（0 文章类新闻 1 视频类新闻 2 图片类新闻 3 文字类新闻 4 转载类新闻）
        addItemType(0, R.layout.news_zreo_type_layout)
        addItemType(1, R.layout.news_one_type_layout)
        addItemType(2, R.layout.news_two_type_layout)
        addItemType(3, R.layout.news_zreo_type_layout)
        addItemType(4, R.layout.news_zreo_type_layout)
    }

    override fun convert(helper: BaseViewHolder, item: PageData) {
        when (helper.itemViewType) {
            // 文章类
            0 -> {
                helper.setText(R.id.tv_title, item.title)
                    .setText(
                        R.id.tv_time,
                        TimestampUtils.tranStringToString(
                            "yyyy-MM-dd HH:mm:ss",
                            "yyyy-MM-dd",
                            item.publishDate
                        )
                    )
                    .setText(R.id.tv_read_count, item.readCount)
                PLog.i(PLog.TAG, " item.frontCoverImage ${item.frontCoverImage} ")
                if (item.frontCoverImage != null) {
                    GlideUtils.loadImage(
                        mContext,
                        item.frontCoverImage,
                        helper.getView(R.id.iv_right)
                    )
                }
            }

            //新闻类
            1 -> {
                helper.setText(R.id.tv_title, item.title)
                    .setText(
                        R.id.tv_time,
                        TimestampUtils.tranStringToString(
                            "yyyy-MM-dd HH:mm:ss",
                            "yyyy-MM-dd",
                            item.publishDate
                        )
                    )
                    .setText(R.id.tv_read_count, item.readCount)
                if (item.content != null) {
                    GlideUtils.loadImage(
                        mContext,
                        item.content + Constants.THUMBNAIL,
                        helper.getView(R.id.iv_right)
                    )
                }
            }
            //图片类
            2 -> {
                helper.setText(R.id.tv_title, item.title)
                    .setText(
                        R.id.tv_time,
                        TimestampUtils.tranStringToString(
                            "yyyy-MM-dd HH:mm:ss",
                            "yyyy-MM-dd",
                            item.publishDate
                        )
                    )
                    .setText(R.id.tv_read_count, item.readCount)
                if (item.content != null) {

                    var listof = item.content.split(",")
                    //遍历照片集合
                    if (listof.size == 1) {
                        GlideUtils.loadImage(
                            mContext,
                            listof.get(0),
                            helper.getView(R.id.iv_one)
                        )
                    } else if (listof.size == 2) {
                        GlideUtils.loadImage(
                            mContext,
                            listof.get(0),
                            helper.getView(R.id.iv_one)
                        )
                        GlideUtils.loadImage(
                            mContext,
                            listof.get(1),
                            helper.getView(R.id.iv_two)
                        )
                    } else if (listof.size > 2) {
                        GlideUtils.loadImage(
                            mContext,
                            listof.get(0),
                            helper.getView(R.id.iv_one)
                        )
                        GlideUtils.loadImage(
                            mContext,
                            listof.get(1),
                            helper.getView(R.id.iv_two)
                        )
                        GlideUtils.loadImage(
                            mContext,
                            listof.get(2),
                            helper.getView(R.id.iv_three)
                        )
                    }

                }

            }

            3 -> {
                helper.setText(R.id.tv_title, item.title)
                    .setText(
                        R.id.tv_time,
                        TimestampUtils.tranStringToString(
                            "yyyy-MM-dd HH:mm:ss",
                            "yyyy-MM-dd",
                            item.publishDate
                        )
                    )
                    .setText(R.id.tv_read_count, item.readCount)
            }
            4 -> {
                helper.setText(R.id.tv_title, item.title)
                    .setText(
                        R.id.tv_time,
                        TimestampUtils.tranStringToString(
                            "yyyy-MM-dd HH:mm:ss",
                            "yyyy-MM-dd",
                            item.publishDate
                        )
                    )
                    .setText(R.id.tv_read_count, item.readCount)
            }

        }

    }
}