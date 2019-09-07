package com.csj.lovevideo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.FragmentHomeBinding
import com.csj.lovevideo.utils.autoCleared

class HomeFragment:Fragment() {

    var mHomeBinding by autoCleared<FragmentHomeBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home,container,false).apply {
            lifecycleOwner = viewLifecycleOwner
            mHomeBinding = this
        }.root
    }
}