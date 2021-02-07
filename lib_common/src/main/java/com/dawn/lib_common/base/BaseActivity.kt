package com.dawn.lib_common.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseActivity<VDB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    lateinit var viewDataBinding: VDB;
    lateinit var viewModel: VM;
    private var loadingDialog:ProgressDialog?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = getVm();
        viewModel.loadingEvent.observe(this) {
            if (it){
                showLoading()
            }else{
                dismissLoading()
            }

        }
        initData(savedInstanceState)
    }

    abstract fun getLayoutId(): Int


    abstract fun initData(savedInstanceState: Bundle?)

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun getVariableId(): Int

    private fun getVm(): VM {
        val viewModelClass: Class<BaseViewModel>
        val type = javaClass.genericSuperclass
        viewModelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<BaseViewModel> //获取第1个注解即VM的注解类型
        } else {
            //使用父类的类型
            BaseViewModel::class.java
        }
        val viewModel = ViewModelProvider(this).get(viewModelClass) as VM
        if (getVariableId() > 0) {
            viewDataBinding.setVariable(getVariableId(), viewModel)
            lifecycle.addObserver(viewModel)
        }
        return viewModel;
    }

    fun showLoading() {
        if(loadingDialog==null){
            loadingDialog=ProgressDialog(this).apply {
                setMessage("加载中。。。")
            };
        }
        if (!loadingDialog!!.isShowing) {
            loadingDialog!!.show()
        }
    }


    fun dismissLoading() {
        loadingDialog?.dismiss()
    }

}