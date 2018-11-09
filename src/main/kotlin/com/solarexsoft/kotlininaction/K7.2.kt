package com.solarexsoft.kotlininaction

import java.lang.IndexOutOfBoundsException

/**
 * Created by houruhou on 2018/11/1.
 * Desc:
 */
class SPerson(val firstName: String, val lastName: String) : Comparable<SPerson> {
    override fun compareTo(other: SPerson): Int {
        return compareValuesBy(this, other, SPerson::lastName, SPerson::firstName)
    }
}

class TPoint(var x : Int, var y : Int){
    operator fun get(index : Int) : Int {
        return when(index) {
            0 -> x
            1 -> y
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }
    operator fun set(index : Int, value : Int) {
        when(index) {
            0 -> x = value
            1 -> y = value
            else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
        }
    }

    override fun toString(): String {
        return "x = $x,y = $y"
    }

    val notes : String by lazy {
        println("lazy init notes")
        "kotlin"
    }
}

val emails : String by lazy {
    println("lazy init emails")
    "Hello"
}
fun main(args: Array<String>) {
    val p1 = SPerson("Alice", "Smith")
    val p2 = SPerson("Bob", "Johnson")
    println(p1 < p2)
    val tp = TPoint(10, 20)
    println(tp[0])
    println(tp[1])
    tp[1] = 100
    println(tp)
    val a = "java".."kotlin"
    println(a)
    println(a.contains("js"))
    println(a.javaClass)
    println(emails)
    println(tp.notes)
}