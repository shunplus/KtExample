package com.shgbit.ktexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.shgbit.ktexample.R
import com.shgbit.ktexample.bean.BannerData
import com.youth.banner.adapter.BannerAdapter



/**
 * @author xushun on  2020/4/23 15:56.
 * Email：shunplus@163.com
 * Des：
 */
class BannerImageAdapter(
    private val context: Context,
    val  data: MutableList<BannerData>?)
    : BannerAdapter<BannerData, BannerImageAdapter.SimpleViewHolder>(data) {

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): SimpleViewHolder {
        return SimpleViewHolder(
            LayoutInflater.from(context)
            .inflate(R.layout.item_banner, parent, false))
    }


    override fun getItemCount(): Int = data?.size!!



    inner class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView = view.findViewById(R.id.iv_banner)
    }

    override fun onBindView(holder: SimpleViewHolder?, data: BannerData?, position: Int, size: Int) {

    }

}
