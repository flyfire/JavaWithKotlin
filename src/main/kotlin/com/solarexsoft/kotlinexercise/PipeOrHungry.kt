package com.solarexsoft.kotlinexercise

/**
 * Created by Solarex at 10:20 PM/2/27/21
 * Desc:
 */
fun main() {
    val list = listOf<Int>(1, 2, 3, 4)
    list.filter {
        println("filter $it")
        it % 2 == 0
    }.map {
        println("map $it")
        it * 2 + 1
    }.forEach {
        println("foreach $it")
    }
    println("*" * 20)
    list.asSequence()
            .filter {
                println("filter $it")
                it % 2 == 0
            }.map {
                println("map $it")
                it * 2 + 1
            }.forEach {
                println("foreach $it")
            }
}