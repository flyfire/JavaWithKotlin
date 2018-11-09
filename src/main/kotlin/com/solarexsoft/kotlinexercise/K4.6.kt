package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
class SOuter{
    val a: Int = 18

    inner class SInner {
        val a: Int = 28

        fun hello() {
            println(a)
            println(this@SOuter.a)
        }
    }
}

interface OnClickListener {
    fun click()
}

class View {
    var listener: OnClickListener? = null

    fun click() {
        listener?.click()
    }
}
fun main(args: Array<String>) {
    val tmp = SOuter().SInner()
    tmp.hello()

    val view = View()
    view.listener = object: OnClickListener{
        override fun click() {
            println("$this clicked")
        }
    }
    view.click()
}