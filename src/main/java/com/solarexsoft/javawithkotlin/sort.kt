package com.solarexsoft.javawithkotlin

import java.util.*


/*
 * Created by Solarex on 2022/12/23 09:02
 */
fun main() {
    val list = mutableListOf<Int>(10, 2, 3, -1, 0)
    /*
    Collections.sort(list, object : Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            return o1!!-o2!!
        }

    })
     */
    list.sort()
    println(list)
}