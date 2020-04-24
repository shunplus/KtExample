package com.shgbit.ktexample.network

import com.shgbit.ktexample.util.SpUtil
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author xushun on  2020/4/23 21:28.
 * Email：shunplus@163.com
 * Des：
 */
class ResponseInterceptor :Interceptor{
    private var cookie: String by SpUtil("Cookie", "")
    override fun intercept(chain: Interceptor.Chain?): Response? {
        val request = chain?.request()?:return null
        val response = chain.proceed(request)
        val cookies  = mutableListOf<String>()
        response.headers("Set-Cookie").run {
            if (isNotEmpty()){
                forEach {
                    cookies.add(it)
                }
              //本地持久化，过期问题此处没处理
                cookie=  cookies.get(0)
            }
        }
        return response
    }
}