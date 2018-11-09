package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/9.
 * Desc:
 */
typealias Runnable = ()->Unit
class SAMInKotlin {
    fun addTask(runnable: Runnable) {
        println("hi")
    }
}

fun main(args: Array<String>) {
    val sam = SAMInKotlin()
    sam.addTask {
        println("will not run")
    }
}