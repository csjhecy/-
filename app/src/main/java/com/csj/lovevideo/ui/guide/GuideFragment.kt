package com.csj.lovevideo.ui.guide

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginLeft
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.FragmentGuideBinding
import com.csj.lovevideo.di.Injectable
import com.csj.lovevideo.utils.autoCleared
import com.csj.lovevideo.utils.ext.dpToPx
import javax.inject.Inject

class GuideFragment : Fragment(), Injectable {

    private var mGuideBinding by autoCleared<FragmentGuideBinding>()

    private var distanceBetween: Int = 0

    private val dot1LeftDistance by lazy { mGuideBinding.dot1.left }

    @Inject
    lateinit var mGuidePageAdapter: GuidePageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentGuideBinding>(inflater, R.layout.fragment_guide, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                mGuideBinding = this
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mGuideBinding.mGuideAdapter = mGuidePageAdapter
        initDistance()
    }


    /**
     * 两个圆点之间的距离
     */
    private fun initDistance() {
        mGuideBinding.dotRed.post {
            distanceBetween = Math.abs(mGuideBinding.dot2.left - dot1LeftDistance)
            setDotRedMargin(dot1LeftDistance)
            initListener()
        }
    }

    /**
     * 设置圆点的距离
     */
    private fun setDotRedMargin(distance: Int) {
        val params = mGuideBinding.dotRed.layoutParams as ConstraintLayout.LayoutParams
        params.setMargins(distance, 0, 0, 0)
        mGuideBinding.dotRed.layoutParams = params
    }

    private fun initListener() {
        mGuideBinding.guideViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                setDotRedMargin(dot1LeftDistance + Math.round(distanceBetween * (positionOffset + position)))
            }

            override fun onPageSelected(position: Int) {}

        })
    }


}