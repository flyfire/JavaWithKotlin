package com.solarexsoft.kotlinexercise

import java.io.OutputStream
import java.nio.charset.Charset
import kotlin.math.log

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
fun log1(tag: String, target: OutputStream, message: String) {
    target.write("$tag $message\n".toByteArray())
}

fun log2(tag: String) = fun(target: OutputStream) = fun(message: Any?) = target.write("$tag,$message\n".toByteArray())

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried()
 = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

val makeString = fun(byteArray: ByteArray, charset: Charset): String{
    return String(byteArray, charset)
}

fun <P1,P2,R> Function2<P1,P2,R>.partial1(p1: P1) = fun(p2: P2) = this(p1,p2)
fun <P1,P2,R> Function2<P1,P2,R>.partial2(p2: P2) = fun(p1: P1) = this(p1,p2)

val makeStringFromGBK = makeString.partial2(charset("GBK"))

fun main(args: Array<String>) {
    log1("Solarex", System.out, "Hello,world")
    log2("flyfire")(System.out)("Hello,Kotlin")
    ::log1.curried()("SKR")(System.out)("skr,skr")
    val consoleLogWithTag = ::log1.curried()("KrisWu")(System.out)
    consoleLogWithTag("awesome")

    val bytes = "眼镜蛇机动".toByteArray(charset("GBK"))
    println(makeStringFromGBK(bytes))
}