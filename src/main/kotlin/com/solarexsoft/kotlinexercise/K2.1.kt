package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
val str:String = "HelloWorld"
val fromChars:String = String(charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'))

fun main(args: Array<String>) {
    println(str == fromChars)
    println(str === fromChars)

    val sayHello = "hello, \"Trump\""
    val salary = 1000
    println("$$salary")
    println("\$salary")

    val rawString = """
        \t
        \n
        a
        b
        c
    """.trimIndent()
    println(rawString)
    println(rawString.length)
}