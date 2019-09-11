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
import com.csj.lovevideo.utils.ext.getNavigationBarHeight

class HomeFragment:Fragment() {

    var mHomeBinding by autoCleared<FragmentHomeBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home,container,false).apply {
            lifecycleOwner = viewLifecycleOwner
            mHomeBinding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHomeBinding.loveTvHome.title = "首页"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val navigationBarHeight = requireActivity().getNavigationBarHeight()
        val layoutParams = mHomeBinding.loveTvHome.layoutParams
        layoutParams.height = mHomeBinding.loveTvHome.height+navigationBarHeight
        mHomeBinding.loveTvHome.layoutParams = layoutParams
    }
}