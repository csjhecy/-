package com.csj.lovevideo.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.ToolbarLoveTvBinding
import com.csj.lovevideo.utils.autoCleared
import com.csj.lovevideo.utils.ext.getStatusBarHeight

/**
 * 添加自定义Toolbar
 */
class LoveTvToolbar : Toolbar {

    private var mToolbarLoveTvBinding: ToolbarLoveTvBinding by autoCleared()

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        val layoutInflater = LayoutInflater.from(context)
        DataBindingUtil.inflate<ToolbarLoveTvBinding>(
            layoutInflater, R.layout.toolbar_love_tv, this, true
        ).also { mToolbarLoveTvBinding = it }
    }

    override fun setTitle(title: CharSequence?) {
        post {
            mToolbarLoveTvBinding.topTitle.text = title
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val navigationBarHeight = context.getStatusBarHeight()
        val layoutParams = layoutParams
        layoutParams.height = navigationBarHeight+height
        this.layoutParams = layoutParams
    }




}