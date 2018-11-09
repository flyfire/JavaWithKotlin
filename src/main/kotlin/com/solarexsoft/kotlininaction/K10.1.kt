package com.solarexsoft.kotlininaction

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty

/**
 * Created by houruhou on 2018/10/29.
 * Desc:
 */
fun foo(x: Int) = println(x)
fun testSum(x:Int, y:Int) = x+y
var testCounter = 0
fun main(args: Array<String>) {
    val person = Person("Solarex", 18)
    val kClass:KClass<Person> = person.javaClass.kotlin
    println(kClass.constructors)
    println(kClass.nestedClasses)
    println(kClass.qualifiedName)
    println(kClass.simpleName)
    kClass.members.forEach{
        print(it.name + " ")
    }
    println()
    val (x,y) = person
    println(x)
    println(y)

    val kF = ::foo
    kF.call(42)
//    kF.call("abc")
    val kf2:KFunction<Int> = ::testSum
    println(kf2.call(1,2))
    val kp = ::testCounter
    println(kp.get())
    println(kp.set(123))
    println(kp.call())
    println(kp.javaClass.kotlin)
    val mp = Person::age
    println(mp.javaClass.kotlin)
    val a:KProperty<Person>? = null

}