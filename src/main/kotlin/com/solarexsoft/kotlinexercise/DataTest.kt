package com.solarexsoft.kotlinexercise

import com.google.gson.Gson

abstract class AbsQuestion(
    val questionId: String = ""
)

class WordQuestion(
    private val correctOptions: String = ""
) : AbsQuestion() {
    override fun toString(): String {
        return "questionId = $questionId, correctOptions = $correctOptions"
    }
}

fun main() {
    val word = WordQuestion("hello")
    println(word)
    val json = """{
        |"questionId": "1111",
        |"correctOptions": "aaa"
        |}""".trimMargin()
    val question = Gson().fromJson(json, WordQuestion::class.java)
    println(question)
}