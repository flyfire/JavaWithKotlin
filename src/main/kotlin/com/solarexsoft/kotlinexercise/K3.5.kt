package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
fun hello1(vararg ints: Int, str: String = "aaa"){
    ints.forEach(::println)
    println(str)
    println("-----------")
}

fun hello2(vararg ints: Int, another: Int = -1) {
    ints.forEach(::println)
    println(another)
    println("-----------")
}

fun main(args: Array<String>) {
    hello1(1,2,3, str="str")
    hello2(4,5,6, another = -100)
}