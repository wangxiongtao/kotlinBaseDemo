package com.dawn.kotlinbasedemo.http

import com.dawn.kotlinbasedemo.data.ListProjectBean
import retrofit2.http.GET

interface ApiInterface {
    @GET("/article/listproject/0/json")
    suspend fun getListProject(): BaseResponse<ListProjectBean?>
}