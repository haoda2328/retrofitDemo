package com.ling.retrofitdemo

import io.reactivex.Observable
import retrofit2.http.GET


/**
 *
 * @author  hao2.ling
 * @date 2021/3/12
 */
interface ScreenApi {
//https://www.jianshu.com/p/574af9d114d7
    @GET("project/tree/json")
    fun getScreenBean(): Observable<ScreenBean>

}