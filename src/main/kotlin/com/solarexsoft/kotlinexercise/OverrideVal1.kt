package com.solarexsoft.kotlinexercise

open class Data(open val hi: Int = 0)
data class Data2(override val hi: Int = 1, val world: Int = 0): Data(hi)

open class AAAA(open val data: Data = Data(), val hi: Int = 1) {
    init {
        println(data)
        println(hi)
    }
}

class BBBB(override val data: Data2 = Data2()): AAAA() {
    init {
        println(data)
    }
}

class CCCC(override val data: Data2 = Data2()): AAAA(data) {
    init {
        println(data)
    }
}

fun main() {
    BBBB()
    println("*" * 20)
    CCCC()
}