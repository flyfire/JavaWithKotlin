package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2019/4/4.
 * Desc:
 */
class HelloX {
    companion object {
        const val W = 64
        val H = 30

        class InnerStatic {
            companion object {
                fun innerStatic() {
                    println("inner static")
                }
                val inner = 25
            }
        }
    }
}