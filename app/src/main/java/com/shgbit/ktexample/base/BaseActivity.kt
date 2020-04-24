package com.shgbit.ktexample.base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.shgbit.ktexample.R
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * Created by xushun on  2020/3/14 16:08.
 * Email：shunplus@163.com
 * Des：
 */
 abstract class BaseActivity : RxAppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSystemBar(false)
        setContentView(getLayoutId())
        initView()
        initData()
    }

    abstract fun getLayoutId():Int

    abstract fun initView()

    abstract fun initData()



    fun initSystemBar(isLight:Boolean){
        if (Build.VERSION.SDK_INT >= 21) {
            val window = window
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //设置状态栏颜色
            if (isLight) {
                window.statusBarColor = resources.getColor(R.color.white)
            } else {
                window.statusBarColor = resources.getColor(R.color.theme_color)
            }

            //状态栏颜色接近于白色，文字图标变成黑色
            val decor = window.decorView
            var ui = decor.systemUiVisibility
            ui = if (isLight) {
                //light --> a|=b的意思就是把a和b按位或然后赋值给a,   按位或的意思就是先把a和b都换成2进制，然后用或操作，相当于a=a|b
                ui or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                //dark  --> &是位运算里面，与运算,  a&=b相当于 a = a&b,  ~非运算符
                ui and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            }
            decor.systemUiVisibility = ui
        }
    }

}