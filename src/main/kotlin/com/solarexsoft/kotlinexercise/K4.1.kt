package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
interface SA {
    var j:Int
    fun hello() {
        println("SA hello")
        println(j)
    }
}

abstract class SB(open var name: String) {
    abstract fun hello()
}

interface SC {
    fun world()
}

class CD(override var j: Int,override var name: String) : SB(name), SA, SC{
    override fun world() {
        println("world")
    }
    override fun hello() {
        super<SA>.hello()
        println("CD hello")
    }
}

fun main(args: Array<String>) {
    val cd = CD(18, "Solarex")
    cd.hello()
    cd.world()
}
