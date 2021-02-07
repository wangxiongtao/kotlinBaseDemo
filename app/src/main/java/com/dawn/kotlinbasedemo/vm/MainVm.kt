package com.dawn.kotlinbasedemo.vm

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.viewModelScope
import com.dawn.kotlinbasedemo.BR
import com.dawn.kotlinbasedemo.R
import com.dawn.kotlinbasedemo.api.request
import com.dawn.kotlinbasedemo.api.requestSimple
import com.dawn.lib_common.base.BaseViewModel
import com.dawn.lib_common.binding.recyclerview.RVItemAdapter
import com.dawn.lib_common.http.ApiException
import com.dawn.lib_common.http.catchException
import com.dawn.lib_common.http.next
import com.dawn.lib_common.util.takeToast
import com.dawn.lib_common.util.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

class MainVm : BaseViewModel() {
    val responseText=ObservableField<String>("11111");
    private val phone="";
    val pwd="";
    val dataList= ObservableArrayList<ActItemBean>()
    val adapter=object :RVItemAdapter<ActItemBean>(){
        override fun getLayoutId(viewType: Int): Int {
            return R.layout.item_rv
        }

        override fun onBindViewHolder(
            binding: ViewDataBinding,
            item: ActItemBean,
            position: Int
        ) {
           binding.setVariable(BR.item,item)
        }

    }

    override fun onCreate() {
        super.onCreate()
        requestData()
        dataList.add(ActItemBean("D"))
    }

    /**
     * 请求网络
     */
    fun requestData(){
        viewModelScope.launch {
            request(false) {
                getListProject();
            }.next {
                Log.e("data===>","data=====>${this.data}")
                responseText.set(this.data.toString())
            }.catchException {
                when(this){
                    is ApiException ->{

                    }
                    is IOException->{

                    }
                    else->{

                    }
                }
            }
        }
    }

    /**
     * 轮询
     */
    fun requestLoopData(){
        viewModelScope.launch {
            runCatching {
                while (true) {
                    requestSimple {
                        getListProject();
                    }.next {
                        Log.e("data===>","requestLoopData=====>${this.data}")
                    }
                    delay(1 * 1000)//1s请求一次
                }

            }
        }

    }

    /**
     * 类似登录功能的前置判断的流式写法
     */
    fun requestWithTake(){
        viewModelScope.launch {
            takeIf {
                takeToast("请输入电话号码",!phone.isNullOrEmpty())
            }?.takeIf {
                takeToast("请输入密码",!pwd.isNullOrEmpty())
            }?.apply {
                request {
                    getListProject();
                }.next {
                    toast("请求成功")
                }
            }
        }

    }



}