package com.solarexsoft.kotlinexercise

/**
 * Created by Solarex at 7:32 PM/2/28/21
 * Desc:
 */
sealed class IntList {
    object Nil : IntList() {
        override fun toString(): String {
            return "nil"
        }
    }

    data class Cons(val head: Int, val tail: IntList) : IntList()

    fun joinToString(sep: Char = ','): String {
        return when (this) {
            Nil -> {
                "nil"
            }
            is Cons -> {
                "${head}$sep${tail.joinToString(sep)}"
            }
        }
    }

}

fun intListOf(vararg ints: Int): IntList {
    return when (ints.size) {
        0 -> {
            IntList.Nil
        }
        else -> {
            IntList.Cons(
                    ints[0],
                    intListOf(*(ints.slice(1 until ints.size).toIntArray()))
            )
        }
    }
}

fun IntList.sum(): Int {
    return when(this) {
        IntList.Nil -> 0
        is IntList.Cons -> head + tail.sum()
    }
}

operator fun IntList.component1(): Int? {
    return when(this) {
        IntList.Nil -> null
        is IntList.Cons -> head
    }
}

operator fun IntList.component2(): Int? {
    return when(this) {
        IntList.Nil -> null
        is IntList.Cons -> tail.component1()
    }
}

operator fun IntList.component3(): Int? {
    return when(this) {
        IntList.Nil -> null
        is IntList.Cons -> tail.component2()
    }
}
fun main() {
    val list = intListOf(0, 1, 2, 3, 4)
    println(list)
    println(list.joinToString())
    println(list.sum())
    val (first, second, third) = list
    println("$first,$second,$third")
}