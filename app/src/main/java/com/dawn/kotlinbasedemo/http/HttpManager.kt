package com.dawn.kotlinbasedemo.http

import com.dawn.kotlinbasedemo.BuildConfig
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HttpManager private constructor(){
    private var retrofit:Retrofit? = null;

    companion object {
        private var instance: HttpManager? = null
            get() {
                if (field == null) {
                    field = HttpManager()
                }
                return field
            }
        @Synchronized
        fun get(): HttpManager{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }
    init {
        retrofit = Retrofit.Builder()
            .baseUrl("https://www.pgyer.com/apiv2/app/check/")
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClient())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS) //设置读取超时时间
            .writeTimeout(30, TimeUnit.SECONDS) //设置写的超时时间
            .connectTimeout(30, TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            builder.addInterceptor(httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            })
        }
        return builder.build()
    }
    fun getRetrofit():Retrofit?{
        return retrofit;
    }

}