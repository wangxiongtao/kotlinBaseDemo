package com.dawn.kotlinbasedemo.api

import com.dawn.kotlinbasedemo.data.ListProjectBean
import com.dawn.kotlinbasedemo.data.ListProjectBean2
import com.dawn.lib_base.http.retrofit
import retrofit2.http.GET


val Api: ApiInterface by lazy {
    retrofit.create(ApiInterface::class.java)
}


interface ApiInterface {
    @GET("/article/listproject/0/json")
    suspend fun getListProject(): BaseResponse<ListProjectBean?>
    @GET("/article/listproject/0/json")
    suspend fun getListProjec1t(): BaseResponse<ListProjectBean2?>
}