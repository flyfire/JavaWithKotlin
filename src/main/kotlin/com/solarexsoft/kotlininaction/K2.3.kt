package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun evalKotlinStyle(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            evalKotlinStyle(e.right) + evalKotlinStyle(e.left)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

fun evalUseWhen(e: Expr): Int =
        when (e) {
            is Num -> e.value
            is Sum -> evalUseWhen(e.right) + evalUseWhen(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }
fun evalWithLogging(e: Expr) : Int =
        when(e) {
            is Num -> {
                println("num: ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalKotlinStyle(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)),Num(4))))
}