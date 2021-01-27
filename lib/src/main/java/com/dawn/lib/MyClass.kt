package com.dawn.lib
var a1:Int=10
get() {
    return 1000
}


val a:MyClass? by lazy {
    MyClass();
}



fun main() {
    println("=====================a1================${a1}")
    val a=(1+1);

    print("111111===${MyClass().fun1()}")
    val list= arrayListOf<MyClass>();
    list.add(MyClass());
    list.add(MyClass());
    list.add(MyClass());
    list.add(MyClass());
    list.add(MyClass());
    for ((index,value) in list.withIndex()){
        println("===$index====${value}")
    }
    println("=====================================${MyClass().javaClass.name}")
    list.forEach {
        println("=======${it}")
    }
    list.forEachIndexed { _, _ ->


    }

    val myclass:MyClass? by lazy {
        println("=========class======lazy======================")
        MyClass();
    }
    println("=========class======lazy===================${myclass}===")
    println("=========class======lazy===================${myclass}===")
    println("=========class======1111===================${(1*0.4f+2*0.4f+4*0.2f)/(4*(0.4f+0.4f+0.2f))}===")
    println("=========class======1111===================${(1+2+4)/12f}===")



}

class MyClass {

    fun fun1(): Int {
        fun2 {
            111
        }

        return 1110
    }

    private fun fun2(call: () -> Int): Int {
        return call()
    }



}



