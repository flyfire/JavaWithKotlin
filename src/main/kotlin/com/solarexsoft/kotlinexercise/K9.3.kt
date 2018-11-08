package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
fun main(args: Array<String>) {
    val a: List<Number> = listOf(1, 2, 3)
    val b: Comparable<Int> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
}