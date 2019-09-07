package com.csj.lovevideo.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import com.csj.lovevideo.LoveTvApp
import dagger.android.AndroidInjection
import dagger.android.support.HasSupportFragmentInjector

object AppInjector {

    fun init(loveTvApp: LoveTvApp){
        DaggerAppComponent
            .builder()
            .application(loveTvApp)
            .build()
            .inject(loveTvApp)

        loveTvApp.registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity?) {}

            override fun onActivityResumed(activity: Activity?) {}

            override fun onActivityStarted(activity: Activity?) {}

            override fun onActivityDestroyed(activity: Activity?) {}

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}

            override fun onActivityStopped(activity: Activity?) {}

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                handleAcitivty(activity)
            }

        })
    }

    /**
     * 依赖的Fragment 需要被依赖注入
     */
    private fun handleAcitivty(activity: Activity?) {

        if (activity is HasSupportFragmentInjector){
            AndroidInjection.inject(activity)
            Log.e("=====>","handleAcitivty")

        }
    }
}