package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
/**
 * if 是有结果值的表达式，它和Java中的三元运算符相似： (a>b)?a:b
 */
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

class People(val name: String, var isMarried: Boolean) {
}

fun main(args: Array<String>) {
    println(max(2, 3))
    val name = if (args.size > 0) args[0] else "kotlin"
    println("Hello, $name")
    println("\$x")
    println("${args[1]}")
    println("Hello, ${if (args.size > 0) args[0] else "others"}!")
    val person = People("Solarex", false)
    println(person.isMarried)
    val rectangle = Rectangle(400, 300)
    println(rectangle.isSquare)
    println(rectangle.isLongSquare)
}

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
    get() = height == width

    val isLongSquare: Boolean
    get() {
        return height > width
    }
}