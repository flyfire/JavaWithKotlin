package com.solarexsoft.coroutinelearning

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println(Thread.currentThread().name)
        val job = launch {
            repeat(1000) {
                println("挂起中 ${Thread.currentThread().name} $it")
                delay(500L)
            }
        }
        delay(1300L)
        println("${Thread.currentThread().name} waiting")
        job.cancel()
        job.join()
        println("${Thread.currentThread().name} exit")
    }
}