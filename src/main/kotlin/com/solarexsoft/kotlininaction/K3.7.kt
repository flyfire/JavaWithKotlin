package com.solarexsoft.kotlininaction

import java.lang.StringBuilder

/**
 * Created by houruhou on 2018/11/5.
 * Desc:
 */
class PdfPrinter {
    fun println(any: Any?) {
        kotlin.io.println(any)
    }
}

fun main(args: Array<String>) {
    val a = PdfPrinter::println
    a.invoke(PdfPrinter(), "aaa")
    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)

    val list = listOf<IntRange>(
            1..100,
            2..50,
            3..40
    )
    val flatList = list.flatMap { it }

    println(flatList.reduce { acc, i ->  acc + i})

    val c = (0..6).map(::ficatorial).fold(5) {
        acc, i -> acc+i
    }
    println(c)
    val d = (0..6).map(::ficatorial).fold(StringBuilder()) {
        acc, i -> acc.append(i).append(",")
    }
    println(d)

    val e = (0..6).map(::ficatorial).foldRightIndexed(StringBuilder()){
        index, i, acc -> acc.append("$index -> $i,")
    }
    println(e)
    println((0..6).map(::ficatorial).joinToString(","))
}

fun ficatorial(n : Int) : Int {
    if (n == 0) return  1;
    return (1..n).reduce { acc, i -> acc*i }
}