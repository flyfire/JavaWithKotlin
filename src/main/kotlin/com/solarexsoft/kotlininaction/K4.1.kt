package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus")
    }

    fun showOff() = println("I'm focusable")
}

class ButtonK : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    override fun click() = println("I was clicked")

    override fun setFocus(b: Boolean) {
        super.setFocus(b)
    }
}

open class RichButton : Clickable, Focusable {
    final override fun showOff() {
    }

    override fun click() {
    }

    fun disable() {}

    open fun animate() {}
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {
    }

    fun animateTwice() {
    }
}

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk")
}

/*
fun TalkativeButton.giveSpeech(){
    yell()
    whisper()
}
*/

class OuterClass {
    inner class Inner {
        fun getOuterReference(): OuterClass = this@OuterClass
    }
}
sealed class ExprSealed {
    class Num(val value: Int): ExprSealed()
    class Sum(val left: ExprSealed, val right: ExprSealed) : ExprSealed()
}

fun evalExprSealed(e: ExprSealed) : Int =
        when(e) {
            is ExprSealed.Num -> e.value
            is ExprSealed.Sum -> evalExprSealed(e.left) + evalExprSealed(e.right)
            is AnotherExpr -> 0
        }
class AnotherExpr(val another: ExprSealed):ExprSealed()

fun main(args: Array<String>) {
    val btn = ButtonK()
    btn.click()
    btn.showOff()
    btn.setFocus(true)
}