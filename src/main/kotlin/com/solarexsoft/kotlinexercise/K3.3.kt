package com.solarexsoft.kotlinexercise

import javax.print.attribute.standard.MediaSize

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
class Complex(var real: Double, var imaginary: Double) {
    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun plus(scale: Int): Double {
        return real * scale
    }

    operator fun invoke(): Double {
        return Math.hypot(real, imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

class Book {
    infix fun on(any: Any): Boolean {
        return true
    }
}

class Desk {

}

fun main(args: Array<String>) {
    val a = Complex(3.0, 4.0)
    val b = Complex(2.0, 3.0)
    println(a + b)
    println(a + 5)
    println(a())
    if (Book() on Desk()) {
        println("book on desk")
    }
    if (Book().on(Desk())) {
        println("test infix")
    }
}