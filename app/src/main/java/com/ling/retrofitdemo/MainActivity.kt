package com.ling.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var disposables = ArrayList<Disposable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    /**
     * 网络接口测试
     */
    fun test(view: View) {
        RetrofitManager.getInstance()
            .retrofit.create(ScreenApi::class.java)
            .getScreenBean()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(object : Consumer<Throwable> {
                override fun accept(t: Throwable) {
                    Log.i("haodadaurl", "Throwable == " + t.message);
                }

            })
            .subscribe {

                it.apply { Log.i("haodadaurl", "dedao  == $weatherinfo"); }
            }.let { disposables.add(it) }
    }

    /**
     * 切记释放 rxjava观察对象，避免内存泄露
     */
    override fun onDestroy() {
        super.onDestroy()
        disposables?.forEach {
            it.dispose()
        }
    }
}