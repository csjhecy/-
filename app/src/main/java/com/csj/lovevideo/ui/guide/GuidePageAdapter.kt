package com.csj.lovevideo.ui.guide

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.ViewpagerGuideItemBinding
import com.csj.lovevideo.utils.ext.setVisible
import javax.inject.Inject

/**
 * 引导页的pager Adapter
 */
class GuidePageAdapter @Inject constructor() : PagerAdapter() {
    private val mDataImages by lazy { mutableListOf<Int>() }

    init {
        mDataImages.add(R.drawable.guide1)
        mDataImages.add(R.drawable.guide2)
        mDataImages.add(R.drawable.guide3)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val view = View.inflate(container.context, R.layout.viewpager_guide_item, null)
        view.findViewById<AppCompatImageView>(R.id.guide_bg).setImageResource(mDataImages[position])
        view.findViewById<AppCompatImageView>(R.id.center_start).apply {
            setVisible(position == mDataImages.size - 1)
            setOnClickListener {
                setOnImmediatelyExperienceClickListener?.invoke(it)
            }
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, viewObject: Any) {
        container.removeView(viewObject as View)
    }

    override fun isViewFromObject(view: View, viewObject: Any) = view == viewObject

    override fun getCount(): Int = mDataImages.size


    /**
     * 立即体验
     */
    var setOnImmediatelyExperienceClickListener: ((view: View) -> Unit)? = null

}