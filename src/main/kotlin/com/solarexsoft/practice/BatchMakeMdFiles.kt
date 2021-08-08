package com.solarexsoft.practice

import java.io.File

fun main() {
    /*
    for (i in 0..113) {
        if (i < 10) {
            println("00$i")
            File("/Users/houruhou/workspace/learning-notes-md/the-beauty-of-design-pattern/ch00$i.md").createNewFile()
        } else if (i < 100) {
            println("0$i")
            File("/Users/houruhou/workspace/learning-notes-md/the-beauty-of-design-pattern/ch0$i.md").createNewFile()
        } else {
            println(i)
            File("/Users/houruhou/workspace/learning-notes-md/the-beauty-of-design-pattern/ch$i.md").createNewFile()
        }
    }
     */
    val sb = StringBuilder()
    for (i in 0..113) {
        val index = when {
            i < 10 -> "00$i"
            i < 100 -> "0$i"
            else -> "$i"
        }
        sb.append("\t* [](the-beauty-of-design-pattern/ch$index.md)\n")
    }
    println(sb)
}