package com.solarexsoft.coroutinelearning

/**
 * Created by Solarex at 10:25/2020/5/16
 * Desc:
 */
fun test() {
    val a = Runnable { println("a") } // getstatic checkcast
    val b = object : Runnable {   // new dup invokespecial
        override fun run() {
            println("b")
        }
    }
    println(a::class.java)
    println(b::class.java)
    a.run()
    b.run()
}