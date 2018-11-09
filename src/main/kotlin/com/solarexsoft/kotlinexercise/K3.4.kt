package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
class SolarexIterator(val iterator: Iterator<Int>) {
    operator fun next(): Int {
        return iterator.next()
    }

    operator fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}

class SolarexList {
    private val list = ArrayList<Int>()
    fun add(a: Int) {
        list.add(a)
    }

    fun remove(a: Int) {
        list.remove(a)
    }

    operator fun iterator(): SolarexIterator {
         return SolarexIterator(list.iterator())
    }
}

fun main(args: Array<String>) {
    val list = SolarexList()
    for (i in 1..10) {
        list.add(i)
    }
    for (i in list) {
        println(i)
    }

    for (arg in args) {
        println(arg)
    }
}