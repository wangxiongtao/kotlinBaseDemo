package com.dawn.kotlinbasedemo.demo.viewdsl

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Placeholder
import com.dawn.kotlinbasedemo.R
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow


class ViewDSLActivity : AppCompatActivity() {



    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var time1=System.currentTimeMillis()

        val root=ConstraintLayout {
            orientation=LinearLayout.VERTICAL
           layout_width= 100
           layout_height=200
            background_color="#FF6600"
            TextView {
                layout_width= 100
                layout_height=50
                background_color="#FF0000"
                text="00000"

            }
            TextView {
                layout_width= 100
                layout_height=50
                background_color="#0000ff"
                text="11111"
            }
        }
//
//        setContentView(root)
        root.setOnClickListener {  };

        setContentView(R.layout.activity_view_d_s_l)
        time1=System.currentTimeMillis()-time1;
        Log.e("time===>","$time1")
        GlobalScope.launch(Dispatchers.Main) {
            delay(2000)
            findViewById<Placeholder>(R.id.my_holder).setContentId(R.id.bloc)

        }



//        GlobalScope.launch {
//            count().collect(object : FlowCollector<Int>{
//                override suspend fun emit(value: Int) {
//                    Log.e("Flow===>","value")
//                }
//
//            })
//        }
        runBlocking {
            testFlow()
        }
        val a=add(10)
        Log.e("Flow===>","add---------------==$a")

    }


    private fun count(): Flow<Int> = flow {
        var x = 0
        while (true) {
            if (x > 20) {
                break
            }
            emit(x)
            x = x.plus(1)
        }
    }
    @InternalCoroutinesApi
    suspend fun testFlow(){
        flow {
            (5 .. 10).forEach {
                emit(it)
            }
        }.collect(object : FlowCollector<Int>{
            override suspend fun emit(value: Int) {
                Log.e("Flow===>","value==$value")
            }

        })

    }
    fun add(a:Int) =run{
        10*a

    }






}