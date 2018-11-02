package com.solarexsoft.kotlininaction

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * Created by houruhou on 2018/11/1.
 * Desc:
 */
class SSUser {
    var name : String by Delegates.observable("<no name>") { kProperty: KProperty<*>, s: String, s1: String ->
        println("${kProperty.name} changed from $s to $s1")
    }
}

class SSSUser(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main(args: Array<String>) {
    val user = SSUser()
    user.name = "first"
    user.name = "second"

    val suser = SSSUser(mapOf("name" to "john", "age" to 15))
    println(suser.name)
    println(suser.age)
}