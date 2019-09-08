package com.csj.lovevideo.utils.ext

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager


/**
 * 全透状态栏
 */
fun Activity.initWindows(statusColorResId: Int = com.csj.lovevideo.R.color.colorPrimary) {
    val window = window
    val color = resources.getColor(statusColorResId)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        //设置状态栏颜色
        window.statusBarColor = color
        //设置导航栏颜色
        window.navigationBarColor = color
        val contentView = (findViewById<ViewGroup>(android.R.id.content))
        val childAt = contentView.getChildAt(0)
        childAt?.apply {
            fitsSystemWindows = true
        }

    } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        //透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //透明导航栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        //设置contentview为fitsSystemWindows
        val contentView = findViewById<ViewGroup>(android.R.id.content)
        val childAt = contentView.getChildAt(0)
        childAt?.apply {
            fitsSystemWindows = true
        }
        //给statusbar着色
        val view = View(this)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getNavigationBarHeight())
        view.setBackgroundColor(color)
        contentView.addView(view)
    }
}


/**
 * 获取导航栏高度
 * @return 导航栏高度
 */
fun Activity.getNavigationBarHeight(): Int {
    val resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android")
    return getResources().getDimensionPixelSize(resourceId)
}


fun Context.dpToPx(dps: Int): Int {
    return Math.round(resources.displayMetrics.density * dps)
}



