package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
fun main(args: Array<String>) {
    val list = listOf<Int>(1, 5, 6, 7, 8, 2, 3)
    val new = list.map { it*2 + 3 }
    new.forEach(::println)

    println("-----------")
    val listOfRange = listOf<IntRange>(
            1..10,
            2..20,
            3..30
    )
    listOfRange.flatMap { it }.forEach(::println)

    println("-----------")
    listOfRange.flatMap { intRange ->
        intRange.map {
            i -> "NO. $i"
        }
    }.forEach(::println)

    val flatList = listOfRange.flatMap { it }
    val reduce = flatList.reduce { acc, i -> acc + i }
    println(reduce)
}