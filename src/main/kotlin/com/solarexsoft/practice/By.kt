package com.solarexsoft.practice

object M {
    inline fun <reified T> get(): T {
        TODO()
    }
}

interface AAAA {
    fun a1()
    fun a2()
    fun a3()

    companion object : AAAA by M.get()
}

fun main() {
    AAAA.a1()
    AAAA.a2()
    AAAA.a3()
}