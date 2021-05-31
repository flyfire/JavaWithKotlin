package com.solarexsoft.practice

sealed class Size1 {
    object Big: Size1()
    object Small: Size1()
}

sealed class Color1(val map: Map<Size1, String>) {
    class White(map: Map<Size1, String>): Color1(map) {
        override fun log(size: Size1) {
            println(map[size])
        }
    }

    class Dark(map: Map<Size1, String>): Color1(map) {
        override fun log(size: Size1) {
            println(map[size])
        }
    }

    abstract fun log(size: Size1)
}

fun main() {
    val color1 = Color1.White(
        mapOf(
            Size1.Big to "1",
            Size1.Small to "2"
        )
    )
    val size1 = Size1.Big
    color1.log(size1)
    val color2 = Color1.Dark(
        mapOf(
            Size1.Big to "3",
            Size1.Small to "4"
        )
    )
    color2.log(size1)
}