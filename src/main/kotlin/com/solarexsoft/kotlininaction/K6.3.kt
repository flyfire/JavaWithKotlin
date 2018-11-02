package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/26.
 * Desc:
 */
fun main(args: Array<String>) {
    arrayListOf<String>("a", "b")
    val letters = Array<String>(26) {i -> ('a' + i).toString()}
    println(letters.joinToString(""))
    val strings = listOf<String>("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))
    val setA = setOf<Int>(1,2,3)
    println("%d/%d/%d".format(*setA.toTypedArray()))

    val squares = IntArray(10) { i -> (i+1)*(i+1)}
    squares.forEachIndexed{
        index, i ->
        println("squares: $index --> $i")
    }
}