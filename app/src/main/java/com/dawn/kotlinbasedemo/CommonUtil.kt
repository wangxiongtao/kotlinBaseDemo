package com.dawn.kotlinbasedemo

import android.widget.Toast

fun toast(string: String){
    Toast.makeText(MyApp.myApp,string,Toast.LENGTH_SHORT).show()
}