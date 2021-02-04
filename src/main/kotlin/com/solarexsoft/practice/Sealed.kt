package com.solarexsoft.practice

/**
 * Created by Solarex on 2/4/21/3:03 PM
 * Desc:
 */
sealed class AnswerStatus {
    object Away : AnswerStatus()
    object Correct : Answered()
    object Wrong: Answered()
    abstract class Answered: AnswerStatus()
    var answerOption: String = ""
}

fun main() {
    val correct1 = AnswerStatus.Correct
    correct1.answerOption = "1"
    val correct2 = AnswerStatus.Correct
    correct2.answerOption = "2"
    println(correct1 == correct2)
}