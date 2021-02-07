package com.dawn.lib

fun main() {

    testError(null)

}

fun testError(string: String?){
    string!!.toString()
}