package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
val arrayOfInt : IntArray = intArrayOf(1, 2, 3)
val arrayOfChar : CharArray = charArrayOf('a', 'b', 'c')
val arrayOfString :Array<String> = Array(3){i -> "No.$i" }
val arrayOfString2 :Array<String> = arrayOf("solarex", "flyfire")

fun main(args: Array<String>) {
    println(arrayOfString.size)
    println(arrayOfString2.size)
    println(arrayOfChar.joinToString("-"))
    println(arrayOfInt.slice(0 until 1))
    println(arrayOfInt.slice(0..1))
    println(arrayOfString[1])
    println(arrayOfString::class.java.simpleName)
    println(arrayOfInt::class.java.simpleName)
    val b = arrayOfChar::class
    val c = arrayOfChar.javaClass
    val d = arrayOfChar.javaClass.kotlin
    println(b)
    println(c)
    println(d)
}