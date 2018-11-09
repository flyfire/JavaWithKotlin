package com.solarexsoft.kotlininaction

import javax.print.attribute.standard.MediaSize

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
fun main(args: Array<String>){
    val list = listOf<String>("args:", *args);
    println(list)

    // 中缀调用
    val map = mapOf<Int, String>(1.to("one"), 2 to "two", 3.to("three"))
    println(map)

    val (name, age) = "Solarex".toPair(18)
    println(name)
    println(age)
}

infix fun Any.toPair(other: Any) = Pair(this, other)