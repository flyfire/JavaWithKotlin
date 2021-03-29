package com.solarexsoft.kotlinexercise

open class AAAAA(data: Data = Data()) {
    open val data = data

    init {
        println(data)
    }
}

class BBBBB(data: Data2 = Data2()): AAAAA() {
    override val data = data
    init {
        println(data)
    }
}

class CCCCC(data: Data2 = Data2()): AAAAA(data) {
    override val data = data
    init {
        println(data)
    }
}

fun main() {
    BBBBB()
    println("*" * 20)
    CCCCC()
}