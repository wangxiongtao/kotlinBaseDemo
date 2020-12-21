package com.dawn.kotlinbasedemo.http

 class BaseResponse<T> {
    var code:Int=0;
    var message="";
    var data:T?=null;
     override fun toString(): String {
         return "BaseResponse(code=$code, message='$message', data=$data)"
     }

 }