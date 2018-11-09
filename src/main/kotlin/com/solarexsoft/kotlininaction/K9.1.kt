package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/29.
 * Desc:
 */
fun main(args: Array<String>) {
    val items = listOf("one", 42, "two")
    println(items.filterIsInstance<String>())
}