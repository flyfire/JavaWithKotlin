package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
fun makeFunc(): ()-> Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}

fun fibonacci() : () -> Long {
    var first = 0L
    var second = 1L
    return fun():Long {
        val result = second
        second += first
        first = second - first
        return second
    }
}

fun fibonacciIterable() : Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator(){
            override fun hasNext(): Boolean = true

            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }
        }
    }
}

fun add(x : Int) = fun(y : Int) = x+y

fun addExplain(x : Int) : (Int) -> Int {
    return fun(y: Int) : Int {
        return x + y
    }
}

fun main(args: Array<String>) {
    val x = makeFunc()
    x()
    x()
    println("---------------")
    val y = fibonacci()
    println(y())
    println(y())
    println(y())
    println(y())
    println(y())
    println(y())
    println(y())
    println(y())
    println("---------------")
    fibonacciIterable().takeWhile { it < 100 }.forEach(::println)
    /*
    for (i in fibonacciIterable()) {
        if (i > 100)
            break
        println(i)
    }*/
    println("----------------")
    val add5 = add(5)
    println(add5(3))
}