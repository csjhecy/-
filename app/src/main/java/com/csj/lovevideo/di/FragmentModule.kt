package com.csj.lovevideo.di

import com.csj.lovevideo.ui.guide.GuideFragment
import com.csj.lovevideo.ui.spalsh.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributesSplashFragment():SplashFragment

    @ContributesAndroidInjector
    abstract fun contributesGuideFragment():GuideFragment

}