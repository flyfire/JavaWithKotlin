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
    var answerTimes: Int = 0
}

fun main() {
    val correct1 = AnswerStatus.Correct
    correct1.answerOption = "1"
    val correct2 = AnswerStatus.Correct
    correct2.answerOption = "2"
    println(correct1 == correct2)

    var answer1: AnswerStatus = AnswerStatus.Correct
    answer1.answerTimes++
    println(answer1.answerTimes)
    answer1 = AnswerStatus.Correct
    answer1.answerTimes++
    println(answer1.answerTimes)
    answer1 = AnswerStatus.Wrong
    answer1.answerTimes++
    println(answer1.answerTimes)

    var answer2: AnswerStatus = AnswerStatus.Away
    var answerTimes = answer2.answerTimes + 1
    answer2 = AnswerStatus.Correct
    answer2.answerTimes = answerTimes
    answerTimes = answer2.answerTimes + 1
    answer2 = AnswerStatus.Wrong
    answer2.answerTimes = answerTimes
    println(answer2.answerTimes)
    answer2 = AnswerStatus.Away
    println(answer2.answerTimes)

}