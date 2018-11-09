package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
fun main(args: Array<String>) {
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))
    parsePath("~/Workspace/icarbonx/meum.md")
    parsePathUseRegex("~/Workspace/icarbonx/meum.md")
    val kotlinLogo = """| //
|//
|/ \"""
    println(kotlinLogo.javaClass)
    println(kotlinLogo)
    val kLogo = """| //
                .|//
                .|/ \"""
    println(kLogo.trimMargin("."))
    val rawPrice = 9.99
    val price = """${'$'} $rawPrice"""
    println(price)
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, filename: $fileName, extension: $extension")
}

fun parsePathUseRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("dir: $directory, filename: $filename, extension: $extension")
    }
}