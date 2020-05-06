package com.shgbit.ktexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.shgbit.ktexample.R
import com.shgbit.ktexample.bean.BannerData
import com.shgbit.ktexample.util.GlideUtils
import com.youth.banner.adapter.BannerAdapter

/**
 * @author xushun on  2020/4/23 22:39.
 * Email：shunplus@163.com
 * Des：
 */
class ImageNetAdapter(mDatas: List<BannerData?>?, mContext: Context) :
    BannerAdapter<BannerData?, ImageNetAdapter.SimpleViewHolder?>(mDatas) {
    private val mContex: Context
    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): SimpleViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_banner, parent, false)
        return SimpleViewHolder(itemView)
    }

    init {
        mContex = mContext
    }


    inner class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.iv_banner)
    }

    override fun onBindView(
        holder: SimpleViewHolder?,
        data: BannerData?,
        position: Int,
        size: Int
    ) {
        GlideUtils.loadImage(
            mContex,
            data?.FRONT_COVER_IMAGE.toString(),
            holder?.imageView as ImageView
        )

    }
}