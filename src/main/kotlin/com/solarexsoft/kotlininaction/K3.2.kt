package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/23.
 * Desc:
 */
@JvmOverloads
fun <T> joinToString(
        collection: Collection<T>,
        seperator: String = ", ",
        prefix: String = "",
        postfix: String = ""): String {
    val sb = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            sb.append(seperator)
        }
        sb.append(element)
    }
    sb.append(postfix)
    return sb.toString()
}

fun main(args: Array<String>) {
    val list = listOf<Int>(1, 2, 3)
    println(joinToString(list, ";", "(", ")"))
    println(joinToString(list, seperator = ", ", prefix = " ", postfix = "."))
    println(joinToString(list))
}