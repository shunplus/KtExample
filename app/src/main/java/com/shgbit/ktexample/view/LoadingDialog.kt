package com.shgbit.ktexample.view

import android.app.Dialog
import android.content.Context
import com.shgbit.ktexample.R

/**
 * @author xushun on  2020/3/24 23:17.
 * Email：shunplus@163.com
 * Des：
 */
object  LoadingDialog {

    private var dialog:Dialog?=null

    fun show(context:Context){
        cancel()
        dialog=Dialog(context)
        dialog?.let {
            it.setContentView(R.layout.activity_main)
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
            it.show()
        }
//        dialog?.apply {
//           setContentView(R.layout.activity_main)
//            setCancelable(false)
//            setCanceledOnTouchOutside(false)
//            show()
//        }
    }

    fun cancel(){
        dialog?.dismiss()
    }
}