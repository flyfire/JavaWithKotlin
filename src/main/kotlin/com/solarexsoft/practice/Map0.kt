package com.solarexsoft.practice

sealed class Color0 {
    object White: Color0()
    object Dark: Color0()
}

sealed class Size0 {
    object Big: Size0()
    object Small: Size0()
}

fun main() {
    var size: Size0 = Size0.Big
    var color: Color0 = Color0.White

    if (size is Size0.Big && color is Color0.White){
        println("1")
    } else if (size is Size0.Small && color is Color0.White) {
        println("2")
    } else if (size is Size0.Big && color is Color0.Dark) {
        println("3")
    } else if (size is Size0.Big && color is Color0.Dark) {
        println("4")
    }
}
