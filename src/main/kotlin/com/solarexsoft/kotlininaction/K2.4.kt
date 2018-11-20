package com.solarexsoft.kotlininaction

import com.solarexsoft.javawithkotlin.HelloJava
import java.util.*

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
val oneToTen = 1..10

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "fizzbuzz "
    i %3 == 0 -> "fizz "
    i % 5 == 0 -> "buzz "
    else -> "$i "
}

fun main(args: Array<String>) {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }
    println()
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }
    println()
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {
        println("$letter --> $binary")
    }
    println()
    val list = arrayListOf<String>("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index --> $element")
    }
    println()
    println(isLetter('q'))
    println(isNotDigit('8'))
    println(recognize('8'))

    /*
    // for loop range must have iterator
    for (i in "Java".."Scala") {
        print("$i ")
    }*/
    println("Kotlin" in "Java".."Scala")

    "abc".isNullOrBlank()

    val a = HelloJava()
    val b = a.platformType
    val c = a.platformCollection
    c.add("a")

    val number = 10
    val percentage =
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException("a percentage value must be between 0 and 100: $number")
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I dont know"
}