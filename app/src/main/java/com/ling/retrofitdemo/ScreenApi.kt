package com.ling.retrofitdemo

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


/**
 *

 * @author  hao2.ling
 * @date 2021/3/12
 */
interface ScreenApi {
    /**
     *
     */
    @GET("101010100.html")
    fun getScreenBean(): Observable<Response<WeatherBean>>

}