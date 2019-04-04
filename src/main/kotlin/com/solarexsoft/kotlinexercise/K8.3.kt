package com.solarexsoft.kotlinexercise

import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
class Test(val name: String, var age: Int)

inline fun <T> cost(tag: String = "", block: () -> T): T {
    val start = System.nanoTime()
    val t = block()
    println("$tag cost ${System.nanoTime() - start}")
    return t
}

fun main(args: Array<String>) {
    val solarexKt = cost("Kotlin 构造方法") {
        Test::class.primaryConstructor!!.call("solarex", 18)
    }
    val solarexJava = cost("Java构造方法") {
        Test::class.java.getDeclaredConstructor(String::class.java, Int::class.java).newInstance("solarex", 18)
    }
//    Test::class.memberProperties.forEach{
//        println(it::class)
//    }
    cost("Kotlin访问属性") {
        Test::class.memberProperties.firstOrNull { it.name == "age" }?.get(solarexKt)
    }
    cost("Java访问属性") {
        Test::class.java.getDeclaredField("age").apply { isAccessible = true }.get(solarexJava)
    }
    cost("Kotlin修改属性") {
        (Test::class.memberProperties.firstOrNull { it.name == "age" } as? KMutableProperty1<Test, Int>)?.set(solarexKt, 10000)
    }
    cost("Java修改属性") {
        Test::class.java.getDeclaredField("age").apply { isAccessible = true }.set(solarexJava, 1000)
    }
//    Test::class.memberFunctions.forEach(::println)
    cost("Kotlin访问方法") {
        Test::class.memberFunctions.first { it.name == "toString" }.call(solarexKt)
    }
    cost("Java访问方法") {
        Test::class.java.getMethod("toString").invoke(solarexJava)
    }
}
