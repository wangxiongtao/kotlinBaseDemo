package com.dawn.kotlinbasedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dawn.kotlinbasedemo.http.HttpManager
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ticker
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(){
    var job:Job?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a1=HttpManager.get().getRetrofit();
        val a2=HttpManager.get().getRetrofit();
        Log.e("HttpManager===>","a1==${a1}")
        Log.e("HttpManager===>","a2==${a2}")
        Log.e("HttpManager===>","a3==${a2===a1}")
        val vm= ViewModelProvider(this).get(MainVm::class.java)
        vm.dddd()
        launch()
        findViewById<MyView>(R.id.myView).setOnClickListener(){
            vm.job?.cancel()
        }



    }


    private fun launch(){
       job= GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                delay(1000)
                Log.e("HttpManager===>","GlobalScope==${Thread.currentThread().name}")
                launch()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }

}