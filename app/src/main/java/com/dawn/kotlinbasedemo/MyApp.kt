package com.dawn.kotlinbasedemo

import android.app.Application

class MyApp :Application(){

    override fun onCreate() {
        super.onCreate()
        myApp=this;
    }
    companion object{
        var myApp:MyApp?=null;
    }

}