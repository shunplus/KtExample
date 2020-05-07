package com.shgbit.ktexample.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView
import com.chad.library.adapter.base.loadmore.LoadMoreStatus
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.shgbit.ktexample.R

/**
 * @author xushun on  2020/5/7 15:10.
 * Email：shunplus@163.com
 * Des：
 */
class CustomLoadMoreView : BaseLoadMoreView() {
    private var endTips: String? = null

    override fun getLoadComplete(holder: BaseViewHolder): View {
        return holder.getView(R.id.load_more_load_end_view)
    }

    override fun getLoadEndView(holder: BaseViewHolder): View {
        return holder.getView(R.id.load_more_load_end_view)
    }

    override fun getLoadFailView(holder: BaseViewHolder): View {
        return holder.getView(R.id.load_fail_view)
    }

    override fun getLoadingView(holder: BaseViewHolder): View {
        return holder.getView(R.id.loading_view)
    }

    override fun getRootView(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_custom_load_more_view, parent)
    }

    override fun convert(holder: BaseViewHolder, position: Int, loadMoreStatus: LoadMoreStatus) {
        super.convert(holder, position, loadMoreStatus)
        when (loadMoreStatus) {
            LoadMoreStatus.End -> {
                if (endTips?.isNotBlank()!!) {
                    holder.setText(R.id.tv_load_end_tips, endTips)
                }
            }
        }
    }

    fun setEndTips(endTips: String) {
        this.endTips = endTips
    }
}