package com.solarexsoft.kotlininaction

import com.sun.javafx.geom.Path2D

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
val sum = { x: Int, y: Int -> x + y }

fun printProblemCounts(response: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    response.forEach{
        if (it.startsWith("4")){
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach{
        println("$prefix $it")
    }
}
fun main(args: Array<String>) {
    var a = "111"
    println(sum.javaClass)
    println(sum(1, 2))
    println(a)

    val response = listOf<String>("200 OK", "404 not found", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(response)

    printMessageWithPrefix(response, "LOGGER:")
}