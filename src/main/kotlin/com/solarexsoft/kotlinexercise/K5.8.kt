package com.solarexsoft.kotlinexercise

import java.io.File

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
fun main(args: Array<String>) {
    val map = HashMap<Char, Int>()
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace).forEach {
        val count = map[it]
        if (count == null) map[it] = 1
        else map[it] = count + 1
    }
    map.forEach(::println)

    println("----------------")
    File("build.gradle").readText().toCharArray().filterNot(Char::isWhitespace).groupBy { it }.map {
        it.key to it.value.size
    }.forEach(::println)
}