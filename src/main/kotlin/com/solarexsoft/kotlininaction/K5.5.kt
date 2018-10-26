package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/25.
 * Desc:
 */
fun alphabet():String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z'){
            append(letter)
        }
        append("Now I know alphabet")
        return toString()
    }
}
fun alphabetOptimized() = with(StringBuilder()){
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("Now I know alphabet")
    toString()
}

class OuterClassK {
    fun alphabetOptimized() = with(StringBuilder()){
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append(" Now I know alphabet")
        this@OuterClassK.toString() + toString()
    }

    override fun toString() = "Solarex "
}
fun main(args: Array<String>) {
    println(alphabet())
    println(alphabetOptimized())
    val o = OuterClassK()
    println(o.alphabetOptimized())

    fun alpha() = StringBuilder().apply {
        for (letter in 'A'..'Z'){
            append(letter)
        }
        append("\nNow I know alphabet")
    }.toString()

    println(alpha())
}