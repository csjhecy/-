package com.csj.lovevideo.utils.ext

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["visible"])
fun View.setVisible(visible:Boolean){
    visibility = if (visible) View.VISIBLE else View.GONE
}