package com.dawn.kotlinbasedemo.demo.paging

import android.os.Bundle
import androidx.paging.map
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.databinding.ActivityPaging3Binding
import com.dawn.lib_common.base.BaseActivity
import com.dawn.lib_common.util.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class Paging3Activity : BaseActivity<ActivityPaging3Binding, PagingVm>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_paging3
    }

    override fun initData(savedInstanceState: Bundle?) {
        viewDataBinding.btn.setOnClickListener {
//            viewModel.getPageData().observe(this){ data ->
//                data.map {
//                    log("====pagingData2===${it}")
//                }
//
//            }
            GlobalScope.launch {
                viewModel.getPageData2().collectLatest { data ->
                    log("====pagingData1===${data}")
                    data.map {
                        log("====pagingData2===${it}")
                    }
                }
            }


        }

    }

    override fun getVariableId(): Int {
        return BR.vm3
    }


}