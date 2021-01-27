package com.dawn.kotlinbasedemo.vm

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.dawn.kotlinbasedemo.http.ApiException
import com.dawn.kotlinbasedemo.http.catchException
import com.dawn.kotlinbasedemo.http.next
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

class MainVm : BaseViewModel() {
    val responseText=ObservableField<String>("11111");

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



}