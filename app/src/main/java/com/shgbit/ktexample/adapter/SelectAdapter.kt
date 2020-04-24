package com.shgbit.ktexample.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.shgbit.ktexample.R
import com.shgbit.ktexample.bean.Data

/**
 * @author xushun on  2020/3/30 16:57.
 * Email：shunplus@163.com
 * Des：
 */
class SelectAdapter(layoutResId: Int, data: MutableList<Data>) :BaseQuickAdapter<Data,BaseViewHolder>(layoutResId,data ) {
    override fun convert(helper: BaseViewHolder, item: Data) {
     helper.setText(R.id.tv_item_court,item.name)
    }
}