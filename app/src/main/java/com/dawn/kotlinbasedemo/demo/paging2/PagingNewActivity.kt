package com.dawn.kotlinbasedemo.demo.paging2

import android.os.Bundle
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.databinding.ActivityPagingNewBinding
import com.dawn.lib_common.base.BaseActivity

class PagingNewActivity : BaseActivity<ActivityPagingNewBinding, PageNewVm>() {
    override fun getLayoutId()= R.layout.activity_paging_new

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun getVariableId()=BR.pageNewVm
}