package com.ling.retrofitdemo

/**
 *
 * @author  hao2.ling
 * @date 2021/3/16
 */
class WeatherBean {
    var city: String? = null
    var cityid: String? = null
    var temp: String? = null
    var WD: String? = null
    var WS: String? = null
    var SD: String? = null
    var AP: String? = null
    var njd: String? = null
    var WSE: String? = null
    var time: String? = null
    var sm: String? = null
    var isRadar: Boolean? = null
    var Radar: String? = null


    override fun toString(): String {
        return "Response(city=$city, cityid=$cityid, temp=$temp, WD=$WD, WS=$WS, SD=$SD, AP=$AP, njd=$njd, WSE=$WSE, time=$time, sm=$sm, isRadar=$isRadar, Radar=$Radar)"

    }
}