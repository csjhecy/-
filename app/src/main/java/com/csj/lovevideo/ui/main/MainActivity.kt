package com.csj.lovevideo.ui.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.csj.lovevideo.databinding.ActivityMainBinding
import com.csj.lovevideo.ui.spalsh.SplashViewModel
import com.csj.lovevideo.utils.autoCleared
import com.csj.lovevideo.utils.ext.initWindows
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    private var mMainBinding: ActivityMainBinding by autoCleared()

    private val mNavController by lazy { findNavController(com.csj.lovevideo.R.id.navHostFragment) }

    private val mSplashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        initWindows(android.R.color.transparent)
        super.onCreate(savedInstanceState)
        initUi()
        initListener()
    }

    private fun initListener() {
        mNavController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                com.csj.lovevideo.R.id.splashFragment,
                com.csj.lovevideo.R.id.guideFragment -> {
                    mSplashViewModel.setVisibleToolbar(false)
                }
                else -> {
                    mSplashViewModel.setVisibleToolbar(true)
                }
            }
        }
    }


    private fun initUi() {
        setContentView<ActivityMainBinding>(this, com.csj.lovevideo.R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            mSplashModel = mSplashViewModel
        }.also {
            mMainBinding = it
            setSupportActionBar(it.loveTvToolbar)
            it.loveTvToolbar.apply {
                val appBarConfiguration = AppBarConfiguration(setOf(com.csj.lovevideo.R.id.splashFragment, com.csj.lovevideo.R.id.guideFragment))
                setupWithNavController(mNavController, appBarConfiguration)
            }
        }
        //initWindows(android.R.color.transparent)
    }
}
