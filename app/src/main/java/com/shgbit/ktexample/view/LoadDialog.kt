package com.shgbit.ktexample.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.shgbit.ktexample.R
import kotlinx.android.synthetic.main.dialog_loading_cover.*
/**
 * @author xushun on  2020/3/28 10:47.
 * Email：shunplus@163.com
 * Des：菊花圈
 */
class LoadDialog(context: Context, themeResId: Int,layoutId:Int) : Dialog(context, themeResId) {

    private lateinit var linearLayout: ImageView
    private var animation: Animation? = null
    private var layoutId:Int = 0

    /**
     * 构造器传值
     */
    init {
        this.layoutId=layoutId
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        animation = AnimationUtils.loadAnimation(context, R.anim.load_anim)
    }

    override fun show() {
        super.show()
        iv_dialog.startAnimation(animation)
    }

    override fun dismiss() {
        super.dismiss()
        animation?.cancel()
    }
}