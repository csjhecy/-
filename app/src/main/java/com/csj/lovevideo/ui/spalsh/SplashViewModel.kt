package com.csj.lovevideo.ui.spalsh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * SplashViewModel
 */
class SplashViewModel : ViewModel() {

    private val _isVisible by lazy { MutableLiveData<Boolean>() }
    var isVisible:LiveData<Boolean> = _isVisible


    /**
     * 设置是否显示Toolbar
     */
    fun setVisibleToolbar(isVisible:Boolean){
        _isVisible.postValue(isVisible)
    }

}