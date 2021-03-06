package com.solarexsoft.kotlinexercise

import java.lang.reflect.ParameterizedType
import kotlin.reflect.KType
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.typeOf

/**
 * Created by Solarex at 6:35 PM/3/6/21
 * Desc:
 */
open class AA {
    fun String.hello() {
        println("hello")
    }
}

object BB {
    fun hello() {
        println("world")
    }
}

interface CC<in K, out V>

interface Api {
    fun getUsers(): List<String>
}

fun <T> Any.safeAs(): T? {
    return this as? T
}
@ExperimentalStdlibApi
fun main() {
    val cls = AA::class
    cls.declaredFunctions.forEach {
        it.isAccessible = true
        println(it.name)
        println(it.visibility)
    }
    println(cls.declaredMemberFunctions.size)

    BB::class.objectInstance?.hello()

    val mapCls = Map::class
    val mapType = typeOf<Map<String, Int>>()

    mapType.arguments.forEach(::println)

    Api::class.declaredFunctions.first { it.name == "getUsers" }
            .returnType.arguments.forEach(::println)
    Api::getUsers.returnType.arguments.forEach(::println)

    (Api::class.java.getDeclaredMethod("getUsers")
            .genericReturnType as ParameterizedType).actualTypeArguments.forEach(::println)
    Api::class.java.getDeclaredMethod("getUsers").genericReturnType
            .safeAs<ParameterizedType>()?.actualTypeArguments?.forEach(::println)
}