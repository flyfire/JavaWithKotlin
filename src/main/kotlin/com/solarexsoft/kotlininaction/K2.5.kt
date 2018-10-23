package com.solarexsoft.kotlininaction

import java.io.BufferedReader
import java.io.StringReader

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException){
        return null
    } finally {
        reader.close()
    }
}

fun readNumberK(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        //return
        null
    }
    println(number)
}

fun main(args:Array<String>) {
    println(readNumber(BufferedReader(StringReader("123"))))
}