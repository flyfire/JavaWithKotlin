@file:JvmName("SolarexUtils")
package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
var opCount = 0
fun performOperation() {
    opCount++
}
fun reportOperationCount(){
    println("Operation performed $opCount times")
}

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        suffix: String = ""): String{
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(suffix)
    return result.toString()
}

fun Collection<String>.join(
        separator: String = ", ",
        prefix: String = "",
        suffix: String = "") = joinToString(separator, prefix, suffix)

fun String.lastChar(): Char = this.get(this.length-1)
fun String.lastCharK(): Char = get(length - 1)

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main(args: Array<String>) {
    println("Solarex".lastChar())
    println("Flyfire".last())
    println("Solarex".lastCharK())
    val list = arrayListOf<Int>(1, 2, 3)
    list.last()
    list.max()
    println(list.joinToString())
    val strList = listOf<String>("one", "two", "three")
    println(strList.join())
    /* type mismatch
    println(list.join())
    */
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}