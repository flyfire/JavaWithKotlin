package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
fun getName() : String? {
    return "abc"
//    return null
}

fun main(args: Array<String>) {
    val name:String = getName() ?: return
    println(name.length)

    val value: String? = "hello"
    println(value!!.length)
}