package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
class A {
    var b: Int = 0
        get() {
            println("tries to get b")
            return field
        }
        set(value) {
            println("tries to set b")
            field = value
        }
}

class B {
    var b = 0
    lateinit var c : String
    val d by lazy {
        println("lazy init e")
        "hello"
    }

    init {
        println("new b")
    }
}

class C(val property:Int, notproperty:Int) {
    var anotherField = "abc"
    init {
        println("new c, access $property, $notproperty")
        this::class.members.forEach {
            println(it.name)
        }
    }
}

fun main(args: Array<String>) {
    val a = A()
    println(a.b)
    a.b = 3
    val b = B()
    println(b.b)
    println("--------------")
    println(b.d)
    // kotlin.UninitializedPropertyAccessException: lateinit property c has not been initialized
//    println(b.c)
    Thread{
        println("visit lazy init variable again")
        println(b.d)
        println("------------------")
    }.start()
    println("--------------")
    val c = C(1, 2)
}