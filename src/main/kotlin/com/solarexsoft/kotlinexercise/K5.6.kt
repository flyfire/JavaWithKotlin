package com.solarexsoft.kotlinexercise


/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
val add5 = { i: Int -> i + 5 }
val multiplyBy2 = { i: Int -> i * 2 }

infix fun <P1, P2, R> Function1<P1, P2>.compose(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p: P1): R {
        return function.invoke(this.invoke(p))
    }
}

fun main(args: Array<String>) {
    val i = add5.compose<Int, Int, Int>(multiplyBy2).invoke(3)
    println(i)
    val j = (multiplyBy2 compose add5).invoke(5)
    println(j)
}