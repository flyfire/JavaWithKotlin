package com.solarexsoft.kotlinexercise

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.lang.UnsupportedOperationException

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
fun main(args: Array<String>) {
    while (true) {
        try {
            println("please input like 3 + 4")
            val input = readLine() ?: break
            val splits = input.trim().split(" ")
            if (splits.size < 3) {
                throw IllegalArgumentException("argument error")
            }
            val arg1 = splits[0].toDouble()
            val op = splits[1]
            val arg2 = splits[2].toDouble()
            println("$arg1 $op $arg2 = ${Operator(op).apply(arg1, arg2)}")
        } catch (e: NumberFormatException) {
            println(e.message)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        } catch (e : Exception) {
            println(e.message)
        }

        println("play again(y)?")
        val cmd = readLine()
        if (cmd == null || cmd.toLowerCase() != "y") {
            break
        }
    }
    println("thank you,bye")
}

class Operator(val op: String) {
    val opFunction: (left: Double, right: Double) -> Double

    init {
        opFunction = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            "%" -> { l, r -> l % r }
            else -> throw UnsupportedOperationException(op)
        }
    }

    fun apply(left: Double, right: Double): Double {
        return opFunction(left, right)
    }
}