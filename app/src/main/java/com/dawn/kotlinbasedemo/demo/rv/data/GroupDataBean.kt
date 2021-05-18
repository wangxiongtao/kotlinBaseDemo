package com.dawn.kotlinbasedemo.demo.rv.data

class GroupDataBean {
    var name:String?=null;
    var isGroupHead:Boolean=false
    override fun toString(): String {
        return name?:""
    }

}