package com.dawn.kotlinbasedemo.api

import com.dawn.kotlinbasedemo.data.ListProjectBean
import com.dawn.lib_common.http.BaseResponse
import com.dawn.lib_common.http.retrofit
import retrofit2.http.GET
val Api: ApiInterface by lazy {
    retrofit.create(ApiInterface::class.java)
}
interface ApiInterface {
    @GET("/article/listproject/0/json")
    suspend fun getListProject(): BaseResponse<ListProjectBean?>
}