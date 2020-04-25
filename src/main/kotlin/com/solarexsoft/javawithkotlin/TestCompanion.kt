package com.solarexsoft.javawithkotlin

import com.solarexsoft.kotlininaction.OuterClass

/**
 * Created by houruhou on 2019/4/28.
 * Desc:
 */
class OuterClassJavaWithKotlin {
    companion object {
        val TAG = OuterClassJavaWithKotlin.javaClass.kotlin.simpleName
        val name = OuterClassJavaWithKotlin::class.simpleName
    }
}

fun main(args: Array<String>) {
    println(OuterClassJavaWithKotlin.TAG)
    println(OuterClassJavaWithKotlin.name)
}