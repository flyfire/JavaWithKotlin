package com.solarexsoft.practice

/**
 * Created by Solarex on 12/29/20/11:29 AM
 * Desc:
 */
class OuterClass {
    sealed class State {
        object Idle: State()
        class Init(val name: String): State()
    }
    var state: State? = null
    val a = 1

    fun hi() {
        println("hi")
    }

    fun State.Init.world() {
        println("world")
        println(a)
    }

    fun hello() {
        val state = state as? State.Init ?: return
        state.world()
    }
}
