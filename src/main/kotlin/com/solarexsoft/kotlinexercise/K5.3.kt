package com.solarexsoft.kotlinexercise

import java.lang.StringBuilder

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
fun fibonacci(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc*i }
}

fun main(args: Array<String>) {
    (0..6).map(::fibonacci).forEach(::println)
    val fold = (0..6).map(::fibonacci).fold(5) { acc, i ->
        acc + i
    }
    println(fold)
    val fold1 = (0..6).map(::fibonacci).fold(initial = StringBuilder()) { acc: StringBuilder, i: Int ->
        acc.append(i).append(",")
    }
    println(fold1)
    val str = (0..6).map(::fibonacci).joinToString(",")
    println(str)

    val foldRight = (0..7).map(::fibonacci).foldRight(StringBuilder()) { i: Int, stringBuilder: StringBuilder ->
        stringBuilder.append(i).append(",")
    }
    println(foldRight)
    val tmp = (0..8).map(::fibonacci)

}