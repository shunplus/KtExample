package com.shgbit.ktexample.network

import com.shgbit.ktexample.util.SpUtil
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

//拦截器以及公用参数的处理
class CommonParamsInterceptor : Interceptor {
    private var cookie: String by SpUtil("Cookie", "")
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request: Request = chain!!.request().newBuilder().
        addHeader("Cache-Control", "no-cache").
        addHeader("app", "true").
        addHeader("Content-Type", "application/json").
        addHeader("Cookie",cookie).
        build()
        return chain.proceed(request)
    }

}