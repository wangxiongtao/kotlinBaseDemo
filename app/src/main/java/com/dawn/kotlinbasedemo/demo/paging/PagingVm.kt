package com.dawn.kotlinbasedemo.demo.paging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.dawn.kotlinbasedemo.data.ListProjectBean
import com.dawn.lib_common.base.BaseViewModel

class PagingVm : BaseViewModel() {


    val liveData = MutableLiveData<PagingData<ListProjectBean>>();

    fun getPageData(): LiveData<PagingData<ListProjectBean>> {
        return Pager(
            // Configure how data is loaded by passing additional properties to
            // PagingConfig, such as prefetchDistance.
            PagingConfig(pageSize = 20)
        ) {
            ExamplePagingSource()
        }.liveData
            .cachedIn(viewModelScope)

    }

    fun getPageData2() = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) {
        ExamplePagingSource()
    }.flow
        .cachedIn(viewModelScope);

}