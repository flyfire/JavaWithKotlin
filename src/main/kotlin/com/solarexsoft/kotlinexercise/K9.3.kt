@file:JvmName(name = "TestInline")
package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
@Retention(AnnotationRetention.SOURCE)
annotation class ABC

fun main(args: Array<String>) {

    val a: List<Number> = listOf(1, 2, 3)
    arrayListOf<Int>()
    val b: Comparable<Int> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
    println(isA<String>(1))
    println(isA<Int>("abc"))
    val kotlin = Class.forName("com.solarexsoft.kotlinexercise.TestInline").kotlin
}

inline fun <reified T> isA(value : Any) = value is T

inline fun <T> abc(value: Any) = println(value)
