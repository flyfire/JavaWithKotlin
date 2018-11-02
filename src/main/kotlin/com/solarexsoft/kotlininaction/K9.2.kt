package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/11/2.
 * Desc:
 */

fun xiebian(any : List<Any>) {
    for (item in any) {
        println(item)
    }
}
fun main(args: Array<String>) {
    val str = listOf<String>("1", "2", "3", "0", "j", "a")
    xiebian(str)

    val anyComparator = Comparator<Any> { e1: Any, e2: Any ->
        e1.hashCode() - e2.hashCode()
    }
    println("--------------")
    str.sortedWith(anyComparator)
    xiebian(str)
}