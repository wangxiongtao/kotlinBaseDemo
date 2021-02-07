package com.dawn.lib_common.base

import android.app.Application

open class BaseApp :Application(){

    override fun onCreate() {
        super.onCreate()
        myApp=this;
    }
    companion object{
        var myApp:BaseApp?=null;
    }

}