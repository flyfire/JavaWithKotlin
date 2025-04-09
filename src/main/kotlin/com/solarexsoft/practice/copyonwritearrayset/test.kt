package com.solarexsoft.practice.copyonwritearrayset

import java.util.concurrent.CopyOnWriteArraySet


/*
 * Created by Solarex on 2025/04/07 17:29
 */
fun main() {
    val set = CopyOnWriteArraySet<Int>()
    set.add(1)
    set.add(2)
    set.add(3)
    val iterator = set.iterator()
    while (iterator.hasNext()) {
        val element = iterator.next()
        println("Element: $element")
        iterator.remove() // UnsupportedOperationException
    }
    println(set)
}