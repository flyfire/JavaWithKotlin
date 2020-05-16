package com.solarexsoft.coroutinelearning

import com.solarexsoft.kotlininaction.Person

/**
 * Created by houruhou on 2020/4/9.
 * Desc:
 */
val sum:(Int, Int) -> Int = {x,y -> x+y}

fun abc(){

}

lateinit var a:Person

val f = ::abc

fun main(args: Array<String>) {
    println(::a.isInitialized)
    println("aaaa")
    test()
}


