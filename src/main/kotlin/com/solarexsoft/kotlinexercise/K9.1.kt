package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
data class SComplex(val a: Double, val b: Double): Comparable<SComplex> {
    override fun compareTo(other: SComplex): Int {
        return (value() - other.value()).toInt()
    }

    fun value(): Double{
        return a*a + b*b
    }

    override fun toString(): String {
        return "$a + $b i"
    }
}

fun <T : Comparable<T>> sMaxOf(a: T, b: T): T{
    return if (a > b) a else b
}
fun main(args: Array<String>) {
    val a = SComplex(3.0, 4.0)
    val b = SComplex(1.0, 2.0)
    println(sMaxOf(a, b))
}