package com.solarexsoft.kotlininaction

import kotlin.reflect.KClass

/**
 * Created by houruhou on 2018/11/2.
 * Desc:
 */
fun sfoo(x: Int) = println(x)

@Target(AnnotationTarget.ANNOTATION_CLASS,AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
annotation class SolarexAnnotaion

annotation class DeserializeInterface(val targetClass : KClass<out Any>)
var d = 42

fun main(args: Array<String>) {
    val kf = ::sfoo
    kf.invoke(42)
    kf.call(43)
    println("----------------")
    val kc = kf.javaClass
    kc.methods.iterator().forEach {
        println("${it.name} -> ${it.parameterTypes}")
    }

    val a = 1
    a.javaClass.kotlin

    val b = ::SSUser
    val c = b.call()


    val kdp = ::d
    kdp.setter.call(56)
    println(d)

    val person = Person("Solarex", 18)
    val memberProperty = Person::age
    println(memberProperty.get(person))
}