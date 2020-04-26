package com.shgbit.ktexample.network

import com.shgbit.ktexample.BuildConfig
import com.shgbit.ktexample.api.RxRestServiceApi
import com.shgbit.ktexample.app.Constants
import com.shgbit.ktexample.util.PLog
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 * @author xushun on  2020/3/20 00:17.
 * Email：shunplus@163.com
 * Des：网络请求
 */
class RxRestClient private constructor(){

    lateinit var serviceApi: RxRestServiceApi
    lateinit var retrofit:Retrofit
    private object Holder{
        val INSTANCE=RxRestClient()
    }
    companion object{
      val instance by lazy { Holder.INSTANCE }
    }

    fun creatRetrofit(){
        val okHttpClient =OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor(HttpLogger()).setLevel(
                if (BuildConfig.DEBUG)HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
            )) .addInterceptor(ResponseInterceptor())
            .addInterceptor(CommonParamsInterceptor())
            .hostnameVerifier(TrustAllHostnameVerifier())
            .sslSocketFactory(createSSLSocketFactory())
            .build()
//        val okHttpClient = OkHttpClient().newBuilder().apply {
//            addInterceptor(HttpLoggingInterceptor().setLevel(
//                if (BuildConfig.DEBUG)HttpLoggingInterceptor.Level.BODY
//            else HttpLoggingInterceptor.Level.NONE))
//        }.build()

         retrofit = Retrofit.Builder()
//            .baseUrl("https://iexe.shgbitcloud.com/")
             .baseUrl(Constants.HOST)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        serviceApi=retrofit.create(RxRestServiceApi::class.java)
    }


    fun <T> getService(service:Class<T>):T=retrofit.create(service)


    fun createSSLSocketFactory() : SSLSocketFactory{
        var ssfFactory:SSLSocketFactory

        var  sslContext=SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf(TrustAllCerts()), SecureRandom())
        ssfFactory = sslContext.getSocketFactory();
        return ssfFactory
    }

    class TrustAllHostnameVerifier : HostnameVerifier{
        override fun verify(hostname: String?, session: SSLSession?): Boolean {
           return true
        }
    }

    internal class HttpLogger : HttpLoggingInterceptor.Logger {
        private val mMessage = StringBuilder()
        override fun log(message: String) { // 请求或者响应开始
            var message = message
            if (message.startsWith("--> POST")) {
                mMessage.setLength(0)
            }
            // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
//            val isJson = (message.startsWith("{") && message.endsWith("}")
//                    || message.startsWith("[") && message.endsWith("]"))
//            if (isJson) {
//                message = JsonUtil.formatJson(message)
//            }
            mMessage.append(message + "\n")
            // 请求或者响应结束，打印整条日志
            if (message.startsWith("<-- END HTTP")) {
                PLog.i(PLog.OKHTTP, mMessage.toString())
            }
        }
    }



    class TrustAllCerts : X509TrustManager{

        override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
        }

        override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {

        }

        override fun getAcceptedIssuers(): Array<X509Certificate> {
          return arrayOf()
        }

    }
}