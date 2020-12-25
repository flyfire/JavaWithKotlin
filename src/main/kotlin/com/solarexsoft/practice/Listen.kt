package com.solarexsoft.practice

/**
 * Created by Solarex on 2020/12/9/2:36 PM
 * Desc:
 */
fun main(args: Array<String>) {
    val str = "I sing a secret song to you, each night we are apart."
    println("------------${str.substring(2, 6)}----------")
    println("------------${str.substring(9, 15)}------------")
    println("------------${str.substring(47, 52)}---------------")
    println("------------${str.substring(52, str.length)}----------")
    println(str.length)
}