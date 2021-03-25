package com.solarexsoft.kotlinexercise

import java.util.*
import java.util.concurrent.TimeUnit

fun main() {
    println(test(1609434000000, 1609516800000))
    println("*" * 20)
    println(test(1609520400000, 1609516800000))
    println("*" * 20)
    println(test(1610208000000, 1609516800000))
    println("*" * 20)
}

fun test(mills1: Long, mills2: Long): Long {
    val year1970 = Calendar.getInstance()
    year1970.timeZone = TimeZone.getDefault()
    year1970.set(Calendar.YEAR, 1970)
    year1970.set(Calendar.DAY_OF_YEAR, 1)
    year1970.set(Calendar.HOUR_OF_DAY, 0)
    year1970.set(Calendar.MINUTE, 0)
    year1970.set(Calendar.SECOND, 0)
    year1970.set(Calendar.MILLISECOND, 0)
    val baseTimeMillis = year1970.timeInMillis
    println(baseTimeMillis)
    val oneDay = TimeUnit.DAYS.toMillis(1)
    val day1 = (mills1 - baseTimeMillis) / oneDay
    val day2 = (mills2 - baseTimeMillis) / oneDay
    return day1 - day2
}