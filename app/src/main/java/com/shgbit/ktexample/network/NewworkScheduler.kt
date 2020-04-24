package com.shgbit.ktexample.network

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author xushun on  2020/3/25 22:28.
 * Email：shunplus@163.com
 * Des：
 */
object NewworkScheduler {
    fun<T>compose():ObservableTransformer<T,T>{
        return ObservableTransformer {
            observvable->observvable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        }
    }
}