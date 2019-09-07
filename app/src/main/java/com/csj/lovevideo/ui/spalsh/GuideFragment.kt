package com.csj.lovevideo.ui.spalsh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.FragmentGuideBinding
import com.csj.lovevideo.utils.autoCleared

class GuideFragment : Fragment() {

    var mGuideBinding by autoCleared<FragmentGuideBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentGuideBinding>(inflater, R.layout.fragment_guide, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                mGuideBinding = this
            }.root
    }
}