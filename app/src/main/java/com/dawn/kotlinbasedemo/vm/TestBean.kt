package com.dawn.kotlinbasedemo.vm

 class TestBean(val a:String="",val b1:String="123") {
    val fullName: String
        get() = "$a $b1"

    override fun toString(): String {
        return "TestBean(a='$a', b='$b1')"
    }

}