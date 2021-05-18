package com.dawn.kotlinbasedemo.demo.viewdsl

import android.view.View

class MyData(private val cccc:  View.OnClickListener.() -> Int){
    fun test(){
        val l=View.OnClickListener{

        };
        cccc(l)

        val a=1;


    }

}