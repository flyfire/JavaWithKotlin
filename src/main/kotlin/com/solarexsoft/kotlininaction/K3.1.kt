package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
fun main(args: Array<String>) {
    val set = hashSetOf<Int>(1, 7, 53)
    println(set.javaClass)
    val list = arrayListOf<Int>(1, 7, 53)
    println(list.javaClass)
    val map = hashMapOf<Int, String>(1 to "one", 7 to "seven")
    println(map.javaClass)

    val strings = listOf<String>("first", "second", "third")
    println(strings.javaClass)
    println(strings.last())
    val numbers = setOf<Int>(1, 14, 2)
    println(numbers.max())
}