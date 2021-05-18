package com.dawn.kotlinbasedemo.demo.paint.vm

import androidx.lifecycle.MutableLiveData
import com.dawn.lib_common.base.BaseViewModel

class PaintVm:BaseViewModel {
    constructor(){

    }
    val skip=MutableLiveData<Boolean>();
    fun toSkip(){
        skip.value=true;
    }
}