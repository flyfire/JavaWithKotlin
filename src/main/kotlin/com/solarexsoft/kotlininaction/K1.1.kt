package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf<Person>(Person("Alice"), Person("Bob", 28))
    val oldest = persons.maxByOrNull { it.age ?: 0 }
    println("the oldest is : $oldest")
    val x = 1
    val enum = 1
    println("$enum")
    println(Color.YELLOW.rgb())
    println(getMnemonic(Color.RED))
    println(getWarmth(Color.ORANGE))
    println(mix(Color.RED, Color.YELLOW))
    println(mixOptimized(Color.RED, Color.YELLOW))
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color): String {
    return when (color) {
        Color.RED -> "Richard"
        Color.YELLOW -> "York"
        Color.ORANGE -> "Of"
        else -> "Solarex"
    }
}

fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE -> "warm"
    Color.YELLOW -> "netual"
    else -> "cold"
}

fun mix(c1: Color, c2: Color) = when(setOf<Color>(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW,Color.BLUE) -> Color.GREEN
    setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
    else -> throw Exception("dirty color")
}

fun mixOptimized(c1:Color, c2:Color) =
        when {
            (c1 == Color.RED && c2 == Color.YELLOW) ||
                    (c1 == Color.YELLOW && c2 == Color.RED) -> Color.ORANGE
            (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                    (c1 == Color.BLUE && c2 == Color.YELLOW) -> Color.GREEN
            else -> throw Exception("dirty color")
        }