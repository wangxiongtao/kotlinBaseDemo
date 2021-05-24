package com.dawn.kotlinbasedemo.vm

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.dawn.kotlinbasedemo.http.ApiException
import com.dawn.kotlinbasedemo.http.catchException
import com.dawn.kotlinbasedemo.http.next
import com.dawn.kotlinbasedemo.takeToast
import com.dawn.kotlinbasedemo.toast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

class MainVm : BaseViewModel() {
    val responseText=ObservableField<String>("11111");
    val responseTextFlow=ObservableField<String>("11111");
    private val phone="";
    val pwd="";

    fun requestFlowData(){
        viewModelScope.launch {
            //单独处理异常
            requestFow() {
                getListProject()
            }.catch {
                Log.e("requestFow", "==catch=========>${this}")
            }. next{
                Log.e("requestFow", "==collect=---------------=next==>${this}")
                responseTextFlow.set(data.toString())
            }

            //不需要单独处理异常
//            requestFow {
//                getListProject()
//            }.next {
//                responseTextFlow.set(data.toString())
//            }
        }
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
                    is ApiException->{

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