package com.solarexsoft.kotlininaction

import java.util.*

/**
 * Created by houruhou on 2018/12/21.
 * Desc:
 */
fun main(args: Array<String>) {
    val a = Random().nextInt(4);
    println(a)
    println(Inject.a)
    println(Inject.b)
}

object Inject {
    private lateinit var manager: String
    val a = 1>=1
    val b = 1<=1
}