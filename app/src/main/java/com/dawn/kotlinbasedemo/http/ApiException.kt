package com.dawn.kotlinbasedemo.http

class  ApiException  (val code:Int?, private val msg:String):Exception(msg) {



}
