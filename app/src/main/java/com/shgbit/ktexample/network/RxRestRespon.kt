package com.shgbit.ktexample.network

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.shgbit.ktexample.R
import com.shgbit.ktexample.bean.ResponseWrapper
import com.shgbit.ktexample.ui.MainActivity
import com.shgbit.ktexample.view.LoadDialog
import com.shgbit.ktexample.view.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author xushun on  2020/3/24 23:07.
 * Email：shunplus@163.com
 * Des：处理返回数据
 */
abstract class RxRestRespon<T>(private val context: Context):Observer<ResponseWrapper<out T>> {
    private var isShowingLoading=true
    private var alertDialog: LoadDialog? = null


    init {
        alertDialog= LoadDialog(context, R.style.HobbyDialog,R.layout.dialog_loading_cover)
    }
    constructor(context: Context,isShowingLoading:Boolean=true):this(context){
        this.isShowingLoading=isShowingLoading
    }

    abstract fun onSucess(data:T)
    abstract fun  onFailure(statusCode:Int,apiError:ApiError)

    override fun onSubscribe(d: Disposable) {
      //show dialog
        Log.d(MainActivity.TAG," onSubscribe ")
        if (isShowingLoading){
            alertDialog?.show()

        }
    }

    override fun onNext(t: ResponseWrapper<out T>) {
        Toast.makeText(context,"1212121",Toast.LENGTH_LONG).show()
        Log.d(MainActivity.TAG," onNext ")
        onSucess(t.data)
    }

    override fun onError(e: Throwable) {
        Log.d(MainActivity.TAG," e   $e ")
        LoadingDialog.cancel()
        isShowingLoading=false
        alertDialog?.dismiss()
        //处理失败
        if(e is HttpException){
            val apiError: ApiError = when (e.code()) {
                ApiErrorType.INTERNAL_SERVER_ERROR.code ->
                    ApiErrorType.INTERNAL_SERVER_ERROR.getApiError(context)
                ApiErrorType.BAD_GATEWAY.code ->
                    ApiErrorType.BAD_GATEWAY.getApiError(context)
                ApiErrorType.NOT_FOUND.code ->
                    ApiErrorType.NOT_FOUND.getApiError(context)
                else -> otherError(e)
            }
            onFailure(e.code(), apiError)
            return
        }
        val apiErrorType: ApiErrorType = when (e) {
            is UnknownHostException -> ApiErrorType.NETWORK_NOT_CONNECT
            is ConnectException -> ApiErrorType.NETWORK_NOT_CONNECT
            is SocketTimeoutException -> ApiErrorType.CONNECT_TIMEOUT
            else -> ApiErrorType.UNKNOWN_ERROR
        }
        onFailure(apiErrorType.code, apiErrorType.getApiError(context))
    }

    private fun otherError(e:HttpException)=Gson().fromJson(e.response().errorBody()?.charStream(),ApiError::class.java)


    override fun onComplete() {
        alertDialog?.cancel()
        isShowingLoading=false
    }

}