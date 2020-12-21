package com.dawn.kotlinbasedemo.http

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Streaming
import java.util.HashMap

interface ApiInterface {
    @GET("https://www.pgyer.com/apiv2/app/check")
    suspend fun getUpgradeInfo(@QueryMap hashMap:HashMap<String, String> ): BaseResponse<UpgradeBean?>
    @GET("http://beta.media.treector.com/e2f5441da46b105f0060c4cc0f6001a2.mp4")
    @Streaming
    suspend fun downLoadFile(): ResponseBody
}