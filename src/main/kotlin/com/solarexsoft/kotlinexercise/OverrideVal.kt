package com.solarexsoft.kotlinexercise

data class IntRef(
    val hi: Int = 0
)
open class GroupRunningData(
    open val next: IntRef = IntRef()
)

class SpeakRunningData(
    override val next: IntRef = IntRef(1)
) : GroupRunningData(next)

open class GroupQuestion(
    open val runningData: GroupRunningData = GroupRunningData()
) {
    init {
        println(runningData.next)
    }
}

open class SpeakQuestion(
    override val runningData: SpeakRunningData = SpeakRunningData()
) : GroupQuestion(runningData)

fun main() {
    val speak = SpeakQuestion()
}