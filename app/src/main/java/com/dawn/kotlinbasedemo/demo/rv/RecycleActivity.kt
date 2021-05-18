package com.dawn.kotlinbasedemo.demo.rv

import android.os.Bundle
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.databinding.ActivityRecycleBinding
import com.dawn.lib_common.base.BaseActivity

class RecycleActivity : BaseActivity<ActivityRecycleBinding,RvVm>() {
    private var groupName="";
    override fun getLayoutId(): Int {
        return R.layout.activity_recycle
    }

    override fun initData(savedInstanceState: Bundle?) {
        viewDataBinding.dataRv.addItemDecoration(MyItemDecoration().apply {
            needGroup={
                val item= viewModel.dataList[it];
                item.isGroupHead
            }
            groupName={
                 viewModel.dataList[it].name?.substring(0,1)
            }
        })
    }

    override fun getVariableId(): Int {
        return BR.rvvm
    }
}