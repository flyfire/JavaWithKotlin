package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
fun main(args: Array<String>) {
    for (i in fibonacciSequence) {
        if (i > 100)
            break
        println(i)
    }
}

val fibonacciSequence = sequence {
    yield(1)
    var cur = 1
    var next = 1

    while (true) {
        yield(next)
        val tmp = cur + next
        cur = next
        next = tmp
    }
}