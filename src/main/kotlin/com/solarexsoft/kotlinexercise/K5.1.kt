package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
class Hello {
    fun world() {
        println("hello,world")
    }
    fun printAny(any: Any){
        kotlin.io.println(any)
    }
}

fun main(args: Array<String>) {
    val a = Hello::world
    a.invoke(Hello())
    a(Hello())
    args.filter(String::isNotEmpty).forEach(::println)
    val b = Hello()
    val c = b::world
    c.invoke()
    c()
    args.forEach(b::printAny)
}