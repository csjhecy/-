package com.csj.lovevideo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.ActivityMainBinding
import com.csj.lovevideo.ui.spalsh.SplashViewModel
import com.csj.lovevideo.utils.autoCleared
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    private var mMainBinding: ActivityMainBinding by autoCleared()

    private val mNavController by lazy { findNavController(R.id.navHostFragment) }

    private val mSplashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUi()
        initListener()
    }

    private fun initListener() {
        mNavController.addOnDestinationChangedListener { _, destination, _ ->
            mSplashViewModel.setVisibleToolbar(destination.id != R.id.splashFragment)
        }
    }



    private fun initUi() {
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .apply {
                lifecycleOwner = this@MainActivity
            }
            .also {
                mMainBinding = it
                it.loveTvToolbar.apply {
                    setSupportActionBar(this)
                    setupWithNavController(mNavController)
                }
            }
    }
}
