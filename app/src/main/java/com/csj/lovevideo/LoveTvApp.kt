package com.csj.lovevideo

import android.app.Activity
import android.app.Application
import android.util.Log
import com.csj.lovevideo.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LoveTvApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = dispatchingAndroidInjector
    override fun onCreate() {
        super.onCreate()
        init()

    }

    private fun init() {
        AppInjector.init(this)
        Log.e("=====>","app init")
    }
}