package com.solarexsoft.javawithkotlin.spannable

import java.lang.StringBuilder


/*
 * Created by Solarex on 2025/01/09 15:48
 */
data class Word(val english: String, val chinese: String)
data class ReplacementInfo(
    val originText: String,
    val replacedText: String,
    val startPosition: Int,
    val endPosition: Int
)

data class ProcessedResult(
    val processedText: String,
    val replacementList: List<ReplacementInfo>
)

fun process(replyText: String, wordList: List<Word>): ProcessedResult {
    val result = StringBuilder(replyText)
    val replacementList = mutableListOf<ReplacementInfo>()
    for (word in wordList) {
        val originText = word.english;
        val replacementText = word.english + "(" + word.chinese + ")";
        var currentIndex = 0;
        while (true) {
            currentIndex = result.indexOf(originText, currentIndex)
            if (currentIndex == -1) {
                break
            }
            result.replace(currentIndex, currentIndex + originText.length, replacementText)
            replacementList.add(
                ReplacementInfo(originText, replacementText, currentIndex, currentIndex + replacementText.length)
            )
            currentIndex += replacementText.length
        }
    }
    return ProcessedResult(result.toString(), replacementList)
}

fun main() {
    val replyText = "Hi, I'm Tom.I'm from icarbonx,welcome to icarbonx!Nice to meet you!"
    val wordList = listOf<Word>(Word("icarbonx", "硅基生命"), Word("Nice to meet you", "很高兴见到你"))
    val processedResult = process(replyText, wordList)
    println(processedResult)
}