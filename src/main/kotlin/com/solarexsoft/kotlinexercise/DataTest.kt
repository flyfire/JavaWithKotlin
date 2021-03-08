package com.solarexsoft.kotlinexercise

abstract class AbsQuestion(
    val questionId: String = ""
)

data class WordQuestion(
    val correctOptions: String = ""
) : AbsQuestion()

fun main() {
    val word = WordQuestion("hello")
    println(word)
}