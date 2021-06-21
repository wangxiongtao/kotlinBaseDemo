package com.dawn.kotlinbasedemo.demo.rv

import android.os.Bundle
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.databinding.ActivityRecycleDiffBinding
import com.dawn.kotlinbasedemo.demo.rv.data.DiffAdapter
import com.dawn.lib_common.base.BaseActivity

class RecycleDiffActivity : BaseActivity<ActivityRecycleDiffBinding,RvVm>() {
    var adapter:DiffAdapter?=null
    val dataList= arrayListOf<String>()

    override fun getLayoutId(): Int {
        return R.layout.activity_recycle_diff
    }

    override fun initData(savedInstanceState: Bundle?) {
        adapter= DiffAdapter()
        viewDataBinding.diffRv.itemAnimator=null
        viewDataBinding.diffRv.adapter=adapter
        dataList.add("0")
        dataList.add("1")
        dataList.add("2")
        dataList.add("3")
        dataList.add("4")
        dataList.add("5")
        dataList.add("6")
        dataList.add("7")

        adapter?.submitList(dataList)





        viewDataBinding.refreshBtn.setOnClickListener {
            val dataList1= mutableListOf<String>()
            dataList1.add("8")
            dataList1.add("9")
            dataList1.add("10")
            dataList1.add("11")
            dataList1.add("12")
            dataList1.add("13")
            dataList1.add("14")
            dataList1.add("15")
            adapter?.submitList(dataList1)
        }
    }

    override fun getVariableId(): Int {
        return BR.vm
    }
}