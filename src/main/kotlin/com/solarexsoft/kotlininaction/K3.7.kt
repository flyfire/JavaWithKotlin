package com.solarexsoft.kotlininaction

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
}