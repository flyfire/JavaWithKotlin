package com.solarexsoft.coroutinelearning

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

suspend fun testFlow() {
    flow<Int> {
        this.emit(1)
        this.emit(2)
        this.emit(3)
    }.collect {
        println(it)
    }
}

fun main() {
    runBlocking {
        testFlow()
    }
}