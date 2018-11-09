package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/26.
 * Desc:
 */
fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're $percent% done")
}

fun main(args: Array<String>) {
    showProgress(146)
}