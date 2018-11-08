package com.solarexsoft.kotlinexercise

import java.lang.StringBuilder

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
fun String.multiply(times: Int): String {
    val sb = StringBuilder()
    for (i in 0 until times) {
        sb.append(this)
    }
    return sb.toString()
}

operator fun String.times(times: Int): String {
    val sb = StringBuilder()
    for (i in 0 until times) {
        sb.append(this)
    }
    return sb.toString()
}

val String.a:String
    get() = "hello,solarex"
fun main(args: Array<String>) {
    println("abc".multiply(16))
    println("solarex" * 5)
    println("a".a)
}