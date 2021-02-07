package com.dawn.lib_common.http

class  ApiException  (val code:Int?, private val msg:String):Exception(msg) {



}
