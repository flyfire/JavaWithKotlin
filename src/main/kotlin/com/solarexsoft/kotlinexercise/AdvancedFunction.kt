package com.solarexsoft.kotlinexercise

/**
 * Created by Solarex at 8:56 PM/2/27/21
 * Desc:
 */
fun fibonacci1(): () -> Long {
    var first = 0L
    var second = 1L
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}

fun main() {
    val fibonacciNext = fibonacci1()
    for (i in 0..10) {
        println(fibonacciNext())
    }
}