package com.shgbit.ktexample.view

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.shgbit.ktexample.R
import com.shgbit.ktexample.util.HobbyUtils

/**
 * @author xushun on  2020/3/30 16:26.
 * Email：shunplus@163.com
 * Des：
 */

class TopViewLayout @JvmOverloads constructor(
    private val mContext: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(mContext, attrs, defStyleAttr) {
    var mBackImage: ImageView
    private val mTitleView: TextView
    private val mRightMenu: ImageView
    var mBackParams: LayoutParams
    var mTitleParams: LayoutParams
    var mMenuParams: LayoutParams
    var mTitle: String? = null
    var mLeftImage = 0
    var rightImage = 0
    var dp8: Int
    fun setTitle(text: String?) {
        mTitleView.text = text
    }

    fun setBackVisiable(visibility: Int){
        mBackImage.visibility=visibility
    }

    fun setRightMenuRes(resId: Int) {
        mRightMenu.setImageResource(resId)
    }

    fun setBackImageRes(resid: Int) {
        mBackImage.setImageResource(resid)
    }

    fun setRightMenuListener(mClick: OnClickListener?) {
        if (mClick != null) {
            mRightMenu.setOnClickListener(mClick)
        }
    }

    fun setBackOnClickListener(mL: OnClickListener?) {
        if (mL != null) {
            mBackImage.setOnClickListener(mL)
        }
    }

    fun setmRightMenuVisable(visable: Boolean) {
        if (visable) {
            mRightMenu.visibility = View.VISIBLE
        } else {
            mRightMenu.visibility = View.GONE
        }
    }

    /**
     * 设置返回按钮的便利方法
     *
     * @param mActivity
     */
    fun setFinishActivity(mActivity: Activity) {
//       if(mBackImage.)
        mBackImage.setOnClickListener { mActivity.finish() }
    }

    /**
     * @param onClickListener 不做处理
     */
    fun setBackImage(onClickListener: OnClickListener?) {
        mBackImage.setOnClickListener(onClickListener)
    }

    companion object {
        const val WARP_CONTENT = LayoutParams.WRAP_CONTENT
        const val MATCH_PARENT = LayoutParams.MATCH_PARENT
    }

    init {
        val array =
            mContext.obtainStyledAttributes(attrs, R.styleable.TopViewLayout, defStyleAttr, 0)
        for (i in 0 until array.length()) {
            val attr = array.getIndex(i)
            when (attr) {
                R.styleable.TopViewLayout_topview_left -> mLeftImage = array.getResourceId(attr, -1)
                R.styleable.TopViewLayout_topview_title -> mTitle = array.getString(attr)
                R.styleable.TopViewLayout_topview_right -> rightImage =
                    array.getResourceId(attr, -1)
                else -> {
                }
            }
        }
        dp8 = HobbyUtils.dp2px(resources, 8f)
        val dp45: Int = HobbyUtils.dp2px(resources, 45f)
        val dp12: Int = HobbyUtils.dp2px(resources, 12f)
        mBackImage = ImageView(mContext)
        mTitleView = TextView(mContext)
        mRightMenu = ImageView(mContext)
        mBackParams = LayoutParams(
            WARP_CONTENT,
            WARP_CONTENT
        )
        mTitleParams = LayoutParams(
            WARP_CONTENT,
            WARP_CONTENT
        )
        mMenuParams = LayoutParams(dp45, dp45)
        mTitleParams.addRule(CENTER_IN_PARENT)
        mMenuParams.addRule(ALIGN_PARENT_RIGHT)
        mMenuParams.addRule(CENTER_VERTICAL)
        mRightMenu.setPadding(dp8, 0, dp12, 0)
        mBackParams.addRule(CENTER_VERTICAL)
        mBackImage.setPadding(0, 0, dp8, 0)
        addView(mBackImage, mBackParams)
        addView(mTitleView, mTitleParams)
        addView(mRightMenu, mMenuParams)
        mTitleView.text = mTitle
        mTitleView.maxLines = 1
        mTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD))
        mTitleView.setPadding(5 * dp8, 0, 5 * dp8, 0)
        if (rightImage > 0) {
            mRightMenu.setImageResource(rightImage)
        }
        if (mLeftImage > 0) {
            mBackImage.setImageResource(mLeftImage)
        }
        setBackgroundResource(R.color.theme_color)
        mTitleView.setTextColor(ContextCompat.getColor(mContext, R.color.white))
        val dimen = resources.getDimensionPixelSize(R.dimen.font_16)
        mTitleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, dimen.toFloat())
        array.recycle()
    }
}