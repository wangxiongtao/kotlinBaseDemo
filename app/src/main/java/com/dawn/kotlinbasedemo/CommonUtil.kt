package com.dawn.kotlinbasedemo

import android.widget.Toast

fun toast(string: String){
    Toast.makeText(MyApp.myApp,string,Toast.LENGTH_SHORT).show()
}
/**
 * 一般结合takeIf使用
 * @param content String?
 * @param notShow Boolean
 * @return Boolean
 */
fun takeToast(content: String?, notShow: Boolean): Boolean {
    if (!notShow) {
        toast(content?:"null")
    }
    return notShow
}