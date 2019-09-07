package com.csj.lovevideo.di

import android.app.Application
import android.content.SharedPreferences
import com.csj.lovevideo.utils.globle.Config
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * dagger2 提供全局实例的工厂
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun providerSp(application: Application): SharedPreferences = application
        .getSharedPreferences(Config.SP.NAME, Application.MODE_PRIVATE)
}