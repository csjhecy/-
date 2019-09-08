package com.csj.lovevideo.ui.spalsh

import android.animation.Animator
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.FragmentSplashBinding
import com.csj.lovevideo.di.Injectable
import com.csj.lovevideo.utils.autoCleared
import com.csj.lovevideo.utils.globle.Config
import javax.inject.Inject

/**
 * 启动页
 */
class SplashFragment : Fragment(), Injectable {

    var mSplashBinding by autoCleared<FragmentSplashBinding>()

    @Inject
    lateinit var mSp: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentSplashBinding>(inflater, R.layout.fragment_splash, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                mSplashBinding = this
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mSplashBinding.splashBg.animate().alpha(1.0f).apply {
            duration = ANIMATE_DURATION
            interpolator = LinearInterpolator()
        }.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {}

            override fun onAnimationEnd(animation: Animator?) {
                goPage()
            }

            override fun onAnimationCancel(animation: Animator?) {}

            override fun onAnimationStart(animation: Animator?) {}

        })
    }

    /**
     * 跳页面
     */
    fun goPage() {
        mSp.getBoolean(Config.SP.KEY_IS_FIRST, true).let {
            if (it) findNavController().navigate(R.id.action_splashFragment_to_guideFragment)
            else findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            mSplashBinding.splashBg.clearAnimation()
        }
    }

    companion object {

        /**
         * 动画时长
         */
        const val ANIMATE_DURATION = 3000L
    }
}
