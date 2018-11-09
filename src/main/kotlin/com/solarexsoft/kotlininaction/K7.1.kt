package com.solarexsoft.kotlininaction

import com.solarexsoft.javawithkotlin.SPoint

/**
 * Created by houruhou on 2018/11/1.
 * Desc:
 */
fun main(args: Array<String>) {
    val a:SPoint = SPoint(1,2)
    val b:SPoint = SPoint(4,5)

    val c = a + b
    println(c)
    val list = listOf<Int>(1,2)
    val mutableList = arrayListOf<Int>(1,2)
//    list+=3
    mutableList += 3
    val listA = list + 3
    println(listA)
    println(listA.javaClass)
}