package com.dawn.kotlinbasedemo.vm

import android.app.Activity
import android.content.Intent

class ActItemBean constructor(val name:String, val clas: Class<*>) {


}

inline fun <reified T : Activity> Activity.startKtxActivity(){
    val intent = Intent(this, T::class.java)
    startActivity(intent)

}
