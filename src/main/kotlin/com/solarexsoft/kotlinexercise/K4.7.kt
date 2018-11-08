package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
enum class LogLevel(val level: Int) {
    VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), ASSERT(5);

    fun getTag(): String{
        return "$level,$name"
    }

    override fun toString(): String {
        return "$ordinal,$name"
    }
}

fun main(args: Array<String>) {
    println(LogLevel.ASSERT.getTag())
    println(LogLevel.VERBOSE.ordinal)
    LogLevel.values().forEach(::println)
    println(LogLevel.valueOf("ERROR"))
}