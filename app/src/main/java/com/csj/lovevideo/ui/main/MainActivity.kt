package com.csj.lovevideo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.ActivityMainBinding
import com.csj.lovevideo.ui.spalsh.SplashViewModel
import com.csj.lovevideo.utils.autoCleared

class MainActivity : AppCompatActivity() {

    var mActivityMainBinding: ActivityMainBinding by autoCleared()

    val mNavController by lazy { findNavController(R.id.navHostFragment) }

    val mSplashViewModel by viewModels<SplashViewModel>()

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
            .also {
                mActivityMainBinding = it
                it.loveTvToolbar.apply {
                    setSupportActionBar(this)
                    setupWithNavController(mNavController)
                }
            }


    }
}
