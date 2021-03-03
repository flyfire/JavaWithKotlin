package com.solarexsoft.kotlinexercise

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by Solarex at 5:41 PM/2/28/21
 * Desc:
 */
val number by lazy {
    Math.random() * 100
}
class Example {
    var p: String by SolarexDelegate()
    var state: Int by Delegates.observable(0) {
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
    var hello: Long by Delegates.vetoable(1L) {
        property, oldValue, newValue ->
        println("${property.name} $oldValue -> $newValue")
        oldValue > newValue
    }
}
class SolarexDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating ${property.name} to me!"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to ${property.name} in $thisRef.")
    }
}

fun main() {
    val example = Example()
    println(example.p)
    example.p = "world"
    example.state = 3
    example.hello = 0
    println(example.hello)
    example.hello = 3
    println(example.hello)
}