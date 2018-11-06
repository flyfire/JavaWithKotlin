package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
val a : IntRange = 0..1024
val b : IntRange = 0 until 1024

val emptyRange : IntRange = 0..-1

fun main(args: Array<String>) {
    println(emptyRange.isEmpty())
    println(a.contains(50))
    println(100 in b)
}