package com.dawn.lib

fun main() {
    println("==================${vvv()}")

}


fun  vvv():Int{
    var a=-1;
     try {
        1/0
        a=10;
    }catch (e:Exception){
         println("==================catch")
        a=-100
    }finally {
        a=90;
         println("==================finally")
         return  50

    }
    return a;
}