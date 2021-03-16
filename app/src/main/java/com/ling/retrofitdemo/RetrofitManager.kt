package com.ling.retrofitdemo

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


/**
 *
 * @author  hao2.ling
 * @date 2021/3/12
 */
class RetrofitManager {
    lateinit var retrofit: Retrofit
    private val BASE_URL = "http://www.weather.com.cn/data/sk/"

    constructor() {
        Log.i("haodadaurl", "constructor()")
        initRetrofit()
    }

    object Hodler {
        val instance = RetrofitManager()
    }

    companion object {

        fun getInstance(): RetrofitManager {
            Log.i("haodadaurl", "getInstance() Hodler.instance == " + Hodler.instance)
            return Hodler.instance;
        }
    }

    /**
     * 初始化  Retrofit
     */
    private fun initRetrofit() {
        Log.i("haodadaurl", "initRetrofit()")
        // OKHttp客户端
        val httpBuilder = OkHttpClient.Builder()
        // 各种参数配置
        val okHttpClient =
            httpBuilder
                // .addNetworkInterceptor(new StethoInterceptor())
                .readTimeout(10000, TimeUnit.SECONDS)
                .connectTimeout(10000, TimeUnit.SECONDS)
                .writeTimeout(10000, TimeUnit.SECONDS)
                .addInterceptor(MyInterceptor())
                .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)//base的网络地址  baseUrl不能为空,且强制要求必需以 / 斜杠结尾
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())////使用Gson解析
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


    }

}