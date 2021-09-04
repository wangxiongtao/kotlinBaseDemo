package com.dawn.lib_base.http

class  ApiException  (val code:Int?, private val msg:String):Exception(msg) {



}
