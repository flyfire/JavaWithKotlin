package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
data class Component(val a:String, val b: String)

fun main(args: Array<String>) {
    val component = Component("solarex", "flyfire")
    val (x,y) = component
    println("$x -> $y")
}