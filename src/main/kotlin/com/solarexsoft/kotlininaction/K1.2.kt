package com.solarexsoft.kotlininaction

import kotlin.reflect.KProperty

/**
 * Created by houruhou on 2018/11/5.
 * Desc:
 */
var String.a : Int
    get() = 5
    set(value) {
        println("aaa")
    }

class A {
    val x by lazy {
        println("getvalue x ${this}")
        "hello"
    }

    var y by SolarexDelegate()
}

class SolarexDelegate {
    private var _value : String? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
        println("getvalue $thisRef -> ${property.name}")
        return _value ?: ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value : String) {
        println("setvalue $thisRef --> ${property.name} --> $value")
        this._value = value
    }
}

fun main(args: Array<String>) {
    val a = A()
    println(a.x)
    println(a.y)
    a.y = "Solarex"
}