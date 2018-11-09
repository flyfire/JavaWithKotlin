package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/9.
 * Desc:
 */
fun main(args: Array<String>) {
    val source = "hello, this is my phone number: 0755-12345678"
    val pattern = """.*(\d{4}-\d{8}).*"""

    Regex(pattern).findAll(source).toList().flatMap(MatchResult::groupValues).forEach(::println)
}