package com.solarexsoft.practice

object M {
    inline fun <reified T> get(): T {
        TODO()
    }
}

interface A {
    fun a1()
    fun a2()
    fun a3()

    companion object : A by M.get()
}

fun main() {
    A.a1()
    A.a2()
    A.a3()
}