package com.solarexsoft.practice

sealed class Color2 {
    object White: Color2()
    object Dark: Color2()
}

sealed class Size2 {
    object Big : Size2()
    object Small: Size2()
}

fun main() {
    val map = mapOf<Color2, Map<Size2, String>>(
        Color2.White to mapOf(
            Size2.Big to "1",
            Size2.Small to "2"
        ),
        Color2.Dark to mapOf(
            Size2.Big to "3",
            Size2.Small to "4"
        )
    )
    println(map[Color2.White]?.get(Size2.Big))
}