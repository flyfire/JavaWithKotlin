package com.solarexsoft.practice

/**
 * Created by Solarex on 2020/5/12/5:05 PM
 * Desc:
 */
fun main(args: Array<String>) {
    var result = true
    println("javascript:jsFunc('$result')")
    result = false
    println("javascript:jsFunc('$result')")
    startCallback(1) {
        println("javascript:jsFunc('$it')")
    }
    var lastSeq = 1
    var currentSeq = 0
    currentSeq = ++lastSeq
    println("last = $lastSeq current = $currentSeq")
    val abc = ABC()
    println(abc.javaClass.name)
    println(abc.javaClass.simpleName)
    println(abc::class.qualifiedName)
    println(abc::class.simpleName)
}

fun startCallback(reqCode: Int, callback: (result: Any) -> Unit) {
    callback(true)
}

class ABC