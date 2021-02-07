package com.dawn.kotlinbasedemo.demo.paging

import androidx.paging.PagingSource
import com.dawn.kotlinbasedemo.api.Api
import com.dawn.kotlinbasedemo.data.ListProjectBean
import com.dawn.lib_common.http.ApiException

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExamplePagingSource :PagingSource<Int,ListProjectBean>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ListProjectBean> {
         try {
           val response = withContext(Dispatchers.IO) {
               /*扩展函数可以很方便的解析出我们想要的数据  接口很多的情况下下可以节省不少无用代码*/
               Api.getListProject()
           }
           if (response.errorCode != 0) {
               throw  ApiException(response.errorCode, response.errorMsg ?: "")
           }
           val responseData = mutableListOf<ListProjectBean>()
           responseData.add(response.data!!);
           return LoadResult.Page(
               data = responseData,
               prevKey = null,
               nextKey = null

           );

       }catch (e:Exception){
           return LoadResult.Error(e)
       }
    }
}