package com.dawn.lib

fun main() {


    class B1 :MyMain{
        constructor(string: Int) : super(string) {
            println("==B==constructor=Int==${string}")
        }
        constructor(string: String) : super(string) {

        }

    }
    B1(1);

}


open class MyMain{
    init {
        println("====init===")
    }

    constructor(string: String) {
        println("====constructor=String==${string}")
    }
    constructor(string: Int) {
        println("====constructor=Int==${string}")
    }

};


