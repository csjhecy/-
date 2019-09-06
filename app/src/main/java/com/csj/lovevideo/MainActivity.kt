package com.csj.lovevideo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.*
import com.csj.lovevideo.databinding.ActivityMainBinding
import com.csj.lovevideo.utils.autoCleared

class MainActivity : AppCompatActivity() {

    var mActivityMainBinding: ActivityMainBinding by autoCleared()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            .also { mActivityMainBinding = it }

        mActivityMainBinding.loveTvToolbar.title = "我是主页"
    }
}
