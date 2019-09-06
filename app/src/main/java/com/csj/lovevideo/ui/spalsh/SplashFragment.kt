package com.csj.lovevideo.ui.spalsh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.FragmentSplashBinding

/**
 * 启动页
 */
class SplashFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentSplashBinding>(inflater, R.layout.fragment_splash, container, false)
            .root
            .apply {

            }
    }
}
