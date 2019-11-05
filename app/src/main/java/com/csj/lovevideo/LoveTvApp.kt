package com.csj.lovevideo

import android.app.Activity
import android.app.Application
import android.util.Log
import com.csj.lovevideo.data.IPreInitCallback
import com.csj.lovevideo.di.AppInjector
import com.tencent.smtt.sdk.QbSdk
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LoveTvApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    private val mPreInitCallback by lazy { IPreInitCallback() }

    override fun activityInjector() = dispatchingAndroidInjector
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        //dagger初始化
        AppInjector.init(this)
        //x5内核初始化接口
        QbSdk.initX5Environment(applicationContext, mPreInitCallback)
    }

}