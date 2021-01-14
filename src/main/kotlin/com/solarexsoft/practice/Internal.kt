package com.solarexsoft.practice

/**
 * Created by Solarex on 12/29/20/12:00 PM
 * Desc:
 */
class InternalOuter {
    internal class InternalInner {
        fun hello() {
            println("hello")
        }
    }

    fun hi() {
        val inner = InternalInner()
        inner.hello()
    }
}

fun main() {
    val outer = InternalOuter()
    outer.hi()
}