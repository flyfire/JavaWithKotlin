package com.solarexsoft.kotlinexercise

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

/**
 * Created by Solarex at 6:35 PM/3/6/21
 * Desc:
 */
class AA {
    fun String.hello() {
        println("hello")
    }
}

object BB {
    fun hello() {
        println("world")
    }
}

fun main() {
    val cls = AA::class
    cls.declaredFunctions.forEach {
        it.isAccessible = true
        println(it.name)
        println(it.visibility)
    }
    println(cls.declaredMemberFunctions.size)

    BB::class.objectInstance?.hello()
}