package com.solarexsoft.kotlininaction

import java.io.File

/**
 * Created by houruhou on 2018/10/25.
 * Desc:
 */
fun main(args: Array<String>) {
    val people = listOf(KPerson("Alice", 27), KPerson("Bob", 28), KPerson("Jan", 30), KPerson("Anna", 18))
    println(people.asSequence().map(KPerson::name).filter { it.startsWith("A") }.toList())
    val sl = listOf(1, 2, 3, 4).asSequence().map { println("map:$it"); it*it }.filter { println("filter:$it"); it%2==0 }.toList()
    println(sl)
    println("--------------------")
    val sll = listOf(1, 2, 3, 4).asSequence().map { println("map:$it"); it*it }.find { println("find:$it"); it > 3 }
    println(sll)
    println("--------------------")
    val slll = listOf(1, 2, 3, 4).map { println("map:$it"); it*it }.find { println("filter:$it"); it > 3 }

    val natualNumbers = generateSequence(0, { it +1 })
    val numbersTo100 = natualNumbers.takeWhile { it <= 100 }
    println(numbersTo100)
    println(numbersTo100.sum())

    fun File.isInsideHideneDirectory() = generateSequence(this) { println("generate " + it.parentFile); it.parentFile}.any { println("any " + it); it.isHidden }
    val id_rsa = File("~/.ssh/id_rsa")
    println(id_rsa.isInsideHideneDirectory())
    println("------------------")
    fun File.findHiddenFile() = generateSequence(this, { println("g: " + it.parentFile); it.parentFile}).find { println("f: " + it); it.isHidden }
    val file = File("~/.ssh/.test")
    println(file.findHiddenFile())
    println("------------------")
}