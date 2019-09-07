package com.csj.lovevideo.di

import com.csj.lovevideo.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity():MainActivity

}