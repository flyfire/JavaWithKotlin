package com.solarexsoft.kotlinexercise

import com.google.gson.Gson

abstract class AbsQuestion(
    val questionId: String = ""
)

data class WordQuestion(
    val correctOptions: String = ""
) : AbsQuestion() {

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