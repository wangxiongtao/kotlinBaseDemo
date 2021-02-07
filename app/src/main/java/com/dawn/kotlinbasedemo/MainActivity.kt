package com.dawn.kotlinbasedemo

import android.os.Bundle
import com.dawn.kotlinbasedemo.databinding.ActivityMainBinding
import com.dawn.kotlinbasedemo.vm.MainVm
import com.dawn.lib_common.base.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding, MainVm>(){
    override fun getLayoutId(): Int {
       return R.layout.activity_main
    }

    override fun initData(savedInstanceState: Bundle?) {

//        viewModel.requestLoopData();
//        viewModel.requestWithTake()


    }

    override fun getVariableId(): Int {
        return BR.mainVm

    }


}