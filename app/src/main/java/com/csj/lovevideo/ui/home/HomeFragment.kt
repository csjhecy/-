package com.csj.lovevideo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.csj.lovevideo.R
import com.csj.lovevideo.databinding.FragmentHomeBinding
import com.csj.lovevideo.utils.autoCleared
import com.csj.lovevideo.utils.ext.getStatusBarHeight
import com.csj.lovevideo.utils.ext.showToast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment() {

    var mHomeBinding by autoCleared<FragmentHomeBinding>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  DataBindingUtil.inflate<FragmentHomeBinding>(inflater, R.layout.fragment_home,container,false).apply {
            lifecycleOwner = viewLifecycleOwner
            mHomeBinding = this
        }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initUI()
        initListener()
    }

    private fun initListener(){
        mHomeBinding.navigationView.setupWithNavController(findNavController())
    }

    private fun initUI(){

        mHomeBinding.loveTvHome.apply {
            title = "首页"
        }
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            requireActivity(),
            mHomeBinding.drawerLayoutMenu,
            mHomeBinding.loveTvHome,
            R.string.app_menu_open,
            R.string.app_menu_close
        )
        actionBarDrawerToggle.syncState()
        mHomeBinding.drawerLayoutMenu.addDrawerListener(actionBarDrawerToggle)
        mHomeBinding.loveTvHome.setNavigationIcon(R.drawable.ic_drawer_home)


         // AppBarConfiguration()
    }
}