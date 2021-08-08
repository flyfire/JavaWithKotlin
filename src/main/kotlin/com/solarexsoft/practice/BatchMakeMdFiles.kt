package com.solarexsoft.practice

import java.io.File

// count dir
fun main(args: Array<String>) {
    val count = args[0].toInt()
    val directory = args[1]
    val split = directory.split("/")
    val directoryName = split[split.lastIndex]
    println("count: $count")
    println("directory: $directory")
    println("directoryName: $directoryName")
    val sb = StringBuilder()
    for (i in 0 until count) {
        val index = if (i < 10) {
            "0$i"
        } else {
            "$i"
        }
        File("$directory/ch$index.md").createNewFile()
        sb.append("\t* []($directoryName/ch$index.md)\n")
    }
    println(sb)
}