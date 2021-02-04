package com.solarexsoft.practice

import java.util.*

/**
 * Created by Solarex on 1/26/21/2:38 PM
 * Desc:
 */
fun main() {
    val list = listOf<String>("I Promise", "Good idea", "Come with me")
    println(list.shuffled())
    println(list)
    val newList = list.shuffled()
    println(newList)
    val newIndex = mutableListOf<Int>()
    list.forEach {
        newIndex.add(newList.indexOf(it))
    }
    println(newIndex)
}