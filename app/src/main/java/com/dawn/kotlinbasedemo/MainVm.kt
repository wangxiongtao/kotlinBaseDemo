package com.dawn.kotlinbasedemo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dawn.kotlinbasedemo.http.ApiInterface
import com.dawn.kotlinbasedemo.http.HttpManager
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ticker
import okhttp3.ResponseBody

class MainVm : ViewModel() {
    var job:Job?=null
   fun dddd(){
       val job1=viewModelScope.launch{
           var a=0;
           while (true){
               a++
               delay(1000)
               Log.e("delay===>", "delay====$a")
           }
       }
       job=job1;
       val job2=viewModelScope.launch {

       }
       Log.e("job===>", "job1==$job1")
       Log.e("job===>", "job2==$job2")
       Log.e("job===>", "job==${job1===job2}")
   }



    fun getData() {
        http(
            block = {
                Log.e("HttpManager===>", "blocCurrentThread==${Thread.currentThread().name}")
                getApi()?.getUpgradeInfo(
                    hashMapOf<String, String>().apply {
                        put("_api_key", "ff046a99462e82406793782b8c866ec1")
                        put("token", "dd0152e23bd1834a13166c45b74c04c7")
                        put("buildVersion", BuildConfig.VERSION_CODE.toString() + "")
                    }
                )
            },
            onNext = {
                Log.e("HttpManager===>", "it==${it}")
                Log.e("HttpManager===>", "it==${it?.data?.downloadURL}")
                Log.e("HttpManager===>", "mainCurrentThread==${Thread.currentThread().name}")
            }

//            block = val hashMap = hashMapOf<String, String>().apply {
//            put("_api_key", "ff046a99462e82406793782b8c866ec1")
//            put("token", "dd0152e23bd1834a13166c45b74c04c7")
//            put("buildVersion", BuildConfig.VERSION_CODE.toString() + "")
//        };
//
//        HttpManager.get().getRetrofit()?.create(ApiInterface::class.java)
//            ?.getUpgradeInfo(hashMap)
        )
    }
    fun getData3() {
        http2(
            block = {
                Log.e("HttpManager===>", "blocCurrentThread==${Thread.currentThread().name}")
                getApi()?.getUpgradeInfo(
                    hashMapOf<String, String>().apply {
                        put("_api_key", "ff046a99462e82406793782b8c866ec1")
                        put("token", "dd0152e23bd1834a13166c45b74c04c7")
                        put("buildVersion", BuildConfig.VERSION_CODE.toString() + "")
                    }
                )
            },
            onNext = {
                Log.e("HttpManager===>", "it==${it}")
                Log.e("HttpManager===>", "it==${it?.data?.downloadURL}")
                Log.e("HttpManager===>", "mainCurrentThread==${Thread.currentThread().name}")
            }

//            block = val hashMap = hashMapOf<String, String>().apply {
//            put("_api_key", "ff046a99462e82406793782b8c866ec1")
//            put("token", "dd0152e23bd1834a13166c45b74c04c7")
//            put("buildVersion", BuildConfig.VERSION_CODE.toString() + "")
//        };
//
//        HttpManager.get().getRetrofit()?.create(ApiInterface::class.java)
//            ?.getUpgradeInfo(hashMap)
        )
    }
    fun getData4() {
        http2(
            block = {
                Log.e("HttpManager===>", "blocCurrentThread==${Thread.currentThread().name}")
                delay(1000)
            },
            onNext = {
                Log.e("HttpManager===>", "it==${it}")
                getData4();

            }

//            block = val hashMap = hashMapOf<String, String>().apply {
//            put("_api_key", "ff046a99462e82406793782b8c866ec1")
//            put("token", "dd0152e23bd1834a13166c45b74c04c7")
//            put("buildVersion", BuildConfig.VERSION_CODE.toString() + "")
//        };
//
//        HttpManager.get().getRetrofit()?.create(ApiInterface::class.java)
//            ?.getUpgradeInfo(hashMap)
        )
    }
    fun getData5() {
        http2(
            block = {
                Log.e("HttpManager===>", "blocCurrentThread==${Thread.currentThread().name}")
                for (a in 1..99){
                    delay(1000)
                }

            },
            onNext = {
                Log.e("HttpManager===>", "it==${it}")
                getData4();

            }

//            block = val hashMap = hashMapOf<String, String>().apply {
//            put("_api_key", "ff046a99462e82406793782b8c866ec1")
//            put("token", "dd0152e23bd1834a13166c45b74c04c7")
//            put("buildVersion", BuildConfig.VERSION_CODE.toString() + "")
//        };
//
//        HttpManager.get().getRetrofit()?.create(ApiInterface::class.java)
//            ?.getUpgradeInfo(hashMap)
        )
    }

    fun getData2() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                Log.e("HttpManager===>", "withContext==${Thread.currentThread().name}")
                for (a in 1..99){
                    delay(1000)
                    withContext(Dispatchers.Main){
                        Log.e("HttpManager===>", "delay==end==${Thread.currentThread().name}===$a")
                    }
                }
            }


        }
    }

    fun downLoadFile(){
        http2(
            block = {
                getApi()?.downLoadFile()?.apply {

                    saveFile(this,MyApp.myApp?.externalCacheDir?.absolutePath?:"","my.mp4"){
                        Log.e("HttpManager===>", "delay==end==${Thread.currentThread().name}===$it")
                    }


                }
            },
            onNext = {

            }
        )
    }


































}