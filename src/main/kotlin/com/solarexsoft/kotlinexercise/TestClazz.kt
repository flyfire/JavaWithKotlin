package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/20.
 * Desc:
 */
open class Foo {
    open fun f() { println("Foo.f()") }
    open val x: Int
        get() = 1
}

/*
class Bar : Foo() {
    override fun f() {
        super.f()
        println("Bar.f()")
    }
    override val x: Int get() = super.x + 1
}*/

class Bar : Foo() {
    override fun f() {
        println("bar.f()")
    }
    override val x: Int get() = 0
    inner class Baz {
        fun g() {
            super@Bar.f() // 调用 Foo 实现的 f()
            println(super@Bar.x) // 使用 Foo 实现的 x 的 getter
            this@Bar.f()
            println(this@Bar.x)
        }
    }
}

fun main(args: Array<String>) {
    val c = Bar().Baz()
    c.g()
}