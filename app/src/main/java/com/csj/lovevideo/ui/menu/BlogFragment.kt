package com.csj.lovevideo.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.FragmentBlogBinding

/**
 * Blog页面
 */
class BlogFragment:Fragment() {

    companion object{

        @JvmStatic
        fun instance():BlogFragment{
            return BlogFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = DataBindingUtil.inflate<FragmentBlogBinding>(
            inflater,
            R.layout.fragment_blog,
            container,
            false
        )
        return inflate.root
    }
}