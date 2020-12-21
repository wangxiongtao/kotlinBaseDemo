package com.dawn.kotlinbasedemo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.kotlinbasedemo.http.ApiInterface
import com.dawn.kotlinbasedemo.http.BaseResponse
import com.dawn.kotlinbasedemo.http.HttpManager
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream


fun getApi():ApiInterface?{
    return HttpManager.get().getRetrofit()?.create(ApiInterface::class.java);
}

fun <T> ViewModel.http(
    block: suspend CoroutineScope.() -> BaseResponse<T?>?,
    onNext: (BaseResponse<T?>?) -> Unit
){
    viewModelScope.launch {

        try {
            Log.e("HttpManager===>", "launchCurrentThread==${Thread.currentThread().name}")
            /*withContext表示挂起块  配合Retrofit声明的suspend函数执行 该块会挂起直到里面的网络请求完成 最一行就是返回值*/
            val data = withContext(Dispatchers.IO) {
                /*扩展函数可以很方便的解析出我们想要的数据  接口很多的情况下下可以节省不少无用代码*/
               block()
            }

            /*给LiveData赋值  ui会自动更新*/
//                fictions.value = data
            onNext(data)

        } catch (e: Exception) {


            /*请求异常的话在这里处理*/
            e.printStackTrace()

            Log.i("HttpManager", "error==${e.message}")


        }
        Log.e("HttpManager===>", "endCurrentThread==${Thread.currentThread().name}")


    }
}
fun <T> ViewModel.http2(block: suspend CoroutineScope.() -> T?, onNext: (T?) -> Unit){
    viewModelScope.launch {

        try {
            Log.e("HttpManager===>", "launchCurrentThread==${Thread.currentThread().name}")
            /*withContext表示挂起块  配合Retrofit声明的suspend函数执行 该块会挂起直到里面的网络请求完成 最一行就是返回值*/
            val data = withContext(Dispatchers.IO) {
                /*扩展函数可以很方便的解析出我们想要的数据  接口很多的情况下下可以节省不少无用代码*/
               block()
            }

            /*给LiveData赋值  ui会自动更新*/
//                fictions.value = data
            onNext(data)

        } catch (e: Exception) {


            /*请求异常的话在这里处理*/
            e.printStackTrace()

            Log.i("HttpManager", "error==${e}")


        }
        Log.e("HttpManager===>", "endCurrentThread==${Thread.currentThread().name}")


    }
}


suspend fun saveFile(
    responseBody: ResponseBody,
    destFileDir: String,
    destFileName: String,
    progress:(Int)->Unit
) {
    var iStream: InputStream? = null
    val buf = ByteArray(2048)
    var len = 0
    var fos: FileOutputStream? = null
    try {
        iStream = responseBody.byteStream()
        val total = responseBody.contentLength()
        var sum: Long = 0
        val dir = File(destFileDir)
        if (!dir.exists()) {
            dir.mkdirs()
        }
        val file = File(dir, destFileName)
        fos = FileOutputStream(file)
        while (iStream.read(buf).also { len = it } != -1) {
            sum += len.toLong()
            fos.write(buf, 0, len)
            val finalSum = sum
            //这里就是对进度的监听回调
            val p = (finalSum * 100 / total).toInt()
           withContext(Dispatchers.Main){
               progress(p);
           }
        }
        fos.flush()
        return
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        try {
            iStream?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        try {
            fos?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
