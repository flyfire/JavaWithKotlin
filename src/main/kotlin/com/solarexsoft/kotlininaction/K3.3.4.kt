@file:JvmName("ExtensionKt")
package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
open class View {
    open fun click() = println("view clicked")
}

class Button: View() {
    override fun click() = println("button clicked")
}

fun View.showOff() = println("I'm a view")
fun Button.showOff() = println("I'm a button")

fun main(args: Array<String>) {
    val view: View = Button()
    view.click()
    view.showOff()
}