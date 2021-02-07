package com.dawn.lib_common.base

import androidx.lifecycle.MutableLiveData

open class BaseViewModel : LifeViewModel() {


    val loadingEvent = MutableLiveData<Boolean>()



    fun showLoading() {
        loadingEvent.value = true
    }

    fun closeLoading() {
        loadingEvent.value = false
    }
}
