package com.csj.lovevideo.di

import android.app.Application
import com.csj.lovevideo.LoveTvApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * dagger2 提供实例的桥梁
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        MainActivityModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(loveTvApp: LoveTvApp)
}