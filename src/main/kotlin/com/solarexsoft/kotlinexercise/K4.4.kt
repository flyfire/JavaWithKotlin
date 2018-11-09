package com.solarexsoft.kotlinexercise

import kotlin.reflect.KProperty

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
class Delegates {
    val hello by X()
    var world by Y()
}
class X {
    operator fun getValue(delegates: Delegates, property: KProperty<*>): String {
        println("getvalue $delegates -> ${property.name}")
        return "hello"
    }
}

class Y{
    private var _world : Int = 0
    operator fun getValue(delegates: Delegates, property: KProperty<*>): Int {
        println("getvalue $delegates -> ${property.name}")
        return _world
    }

    operator fun setValue(delegates: Delegates, property: KProperty<*>, any: Int) {
        println("setvalue $delegates -> ${property.name}")
        _world = any
    }

}

fun main(args: Array<String>) {
    val d = Delegates()
    println("-----------")
    println(d.hello)
    println(d.world)
    d.world = 18
    println(d.world)
}