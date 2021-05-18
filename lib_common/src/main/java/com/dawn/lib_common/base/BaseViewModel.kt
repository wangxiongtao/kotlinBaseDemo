package com.dawn.lib_common.base

import androidx.lifecycle.MutableLiveData

open class BaseViewModel : LifeViewModel() {


    private val loadingEvent = MutableLiveData<Boolean>()
    val startActivity=MutableLiveData<Any>()



    fun showLoading() {
        loadingEvent.value = true
    }

    fun closeLoading() {
        loadingEvent.value = false
    }
}
