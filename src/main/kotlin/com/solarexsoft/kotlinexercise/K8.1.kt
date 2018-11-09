package com.solarexsoft.kotlinexercise

import com.solarexsoft.kotlininaction.Person
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberExtensionFunctions
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
@POJO
data class POJOTest(@FieldAnno val name: String, var age: Int){
    fun String.foo(bar: Int){

    }
}

data class PTest(val name: String = "abc", val age: Int)

fun POJOTest.sayHello() = println("hello")

fun sayHello() {
    println("package say hello")
}

class NoConstructor {
    constructor() {
        println("not primary constructor, no arg")
    }

    constructor(a: Int) {
        println("not primary constructor, arg: $a")
    }
}

fun main(args: Array<String>) {
    val p = POJOTest::class.java.newInstance()
    println(p)
    val q = POJOTest::class.java.getConstructor(String::class.java, Int::class.java).newInstance("solarex", 18)
    println(q)

    val pClz = p.javaClass
    val pkClz = pClz.kotlin
    pkClz.members.forEach {
        println(it.name)
    }
    println("-----------")
    val name = pClz.getDeclaredField("name").apply { isAccessible = true }.get(q)
    println(name)
    val age = pClz.getDeclaredMethod("getAge").invoke(q)
    println(age)
    pClz.getDeclaredField("name").apply { isAccessible = true }.set(q, "flyfire")
    println(q)

    Class.forName("com.solarexsoft.kotlinexercise.K8_1Kt")
            .getDeclaredMethod("sayHello", POJOTest::class.java)
            .invoke(null, q)

    Class.forName("com.solarexsoft.kotlinexercise.K8_1Kt")
            .getDeclaredMethod("sayHello")
            .invoke(null)
    POJOTest::class.java.getAnnotation(POJO::class.java).let(::println)

    POJOTest::class.java.getDeclaredField("name").annotations.forEach(::println)
    POJOTest::class.members.forEach(::println)

    println("-----------member properites")
    POJOTest::class.memberProperties.forEach(::println)
    println("------------member properties class")
    POJOTest::class.memberProperties.forEach{
        println(it::class)
    }
    println("------------member property age")
    (POJOTest::class.memberProperties.first{it.name == "age"} as? KMutableProperty1<POJOTest, Int>)?.set(q, -1)
    println(q)
    println("------------member functions")
    POJOTest::class.memberFunctions.forEach(::println)
    println("------------member extension functions")
    POJOTest::class.memberExtensionFunctions.forEach(::println)
    println("------------field annotation")
    POJOTest::class.memberProperties.first { it.name == "name" }.annotations.forEach(::println)
    println("------------")


    val c = POJOTest::class.primaryConstructor!!.call("flyfire", 20)
    println(c)
    println("------------")
    val first = PTest::class.constructors.first().parameters.first{it.name == "age"}
    val t = PTest::class.primaryConstructor!!.callBy(mapOf(first to 22))
    println(t)
    println("------------")


    NoConstructor::class.constructors.forEach(::println)
}