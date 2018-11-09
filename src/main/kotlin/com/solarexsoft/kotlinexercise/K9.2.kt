package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
inline fun <reified T> testGenerics() {
    println(T::class.simpleName)
}

fun main(args: Array<String>) {
    testGenerics<Int>()
}