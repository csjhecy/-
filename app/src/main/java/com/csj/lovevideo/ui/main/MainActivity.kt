package com.csj.lovevideo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.ActivityMainBinding
import com.csj.lovevideo.utils.ext.initWindows
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWindows(android.R.color.transparent)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

}
