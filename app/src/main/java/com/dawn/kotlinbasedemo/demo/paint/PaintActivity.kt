package com.dawn.kotlinbasedemo.demo.paint

import android.graphics.Rect
import android.os.Bundle
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.databinding.ActivityPaintBinding
import com.dawn.kotlinbasedemo.demo.paint.vm.PaintVm
import com.dawn.lib_common.base.BaseActivity
import com.dawn.lib_common.util.log

/**
 * 冰箱（海尔）
 * 洗衣机（小天鹅）
 * 热水器（万家乐）
 * 燃气灶（老板）
 * 马桶（国产）
 */
class PaintActivity : BaseActivity<ActivityPaintBinding,PaintVm>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_paint
    }

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.skip.observe(this){
            if(it){
//                startKtxActivity<RecycleActivity>()
            }
        }
        viewModel.toString()
        viewDataBinding.dagView.setOnClickListener {
            val rect = Rect()
            it.getGlobalVisibleRect(rect)//全屏的 包括 toolbar
            log("=====childView=rect===>${rect}")
        }

    }

    override fun getVariableId(): Int {
        return BR.paintVm

    }

}