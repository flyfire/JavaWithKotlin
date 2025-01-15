package com.solarexsoft.javawithkotlin.spannable

import java.lang.StringBuilder
import java.util.regex.Pattern


/*
 * Created by Solarex on 2025/01/09 15:48
 */
data class Word(val english: String, val chinese: String)
data class ReplacementInfo(
    val originText: String,     // 原始英文文本
    val replacedText: String,   // 替换后的文本
    val startPosition: Int,     // 在最终文本中的起始位置
    val endPosition: Int        // 在最终文本中的结束位置
)

data class MatchInfo(
    val word: Word,             // 匹配的Wrod对象
    val startPosition: Int,     // 在原始文本中的起始位置
    val endPosition: Int,       // 在原始文本中的结束位置
    val matchedText: String     // 原始匹配的文本
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

fun process2(respText:String, words:List<Word>): ProcessedResult {
    val result = StringBuilder(respText);
    val replacementList = mutableListOf<ReplacementInfo>()
    words.sortedWith(Comparator<Word> { o1, o2 -> o2.english.length - o1.english.length})
    for (word in words) {
        val patternText = Pattern.quote(word.english)
        val pattern = Pattern.compile(patternText, Pattern.CASE_INSENSITIVE)
        var matcher = pattern.matcher(result)
        while (matcher.find()) {
            val startPos = matcher.start()
            val endPos = matcher.end()
            val originText = result.substring(startPos, endPos)
            val replacementText = "[" + originText + "(" + word.chinese + ")]";
            result.replace(startPos, endPos, replacementText)
            replacementList.add(
                ReplacementInfo(
                    originText,
                    replacementText,
                    startPos,
                    startPos + replacementText.length
                )
            )
            matcher = pattern.matcher(result)
            for (replacementInfo in replacementList) {
                matcher.region(replacementInfo.endPosition, result.length)
            }
        }
    }
    return ProcessedResult(result.toString(), replacementList)
}

fun process3(respText: String, words: List<Word>): ProcessedResult {
    val matches = mutableListOf<MatchInfo>()
    for (word in words) {
        val patternText = Pattern.quote(word.english)
        val pattern = Pattern.compile(patternText, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(respText)
        while (matcher.find()) {
            matches.add(
                MatchInfo(
                    word,
                    matcher.start(),
                    matcher.end(),
                    respText.substring(matcher.start(), matcher.end())
                )
            )
        }
    }
    matches.sortWith(Comparator { matchInfo, matchInfo2 -> matchInfo.startPosition - matchInfo2.startPosition })
    val result = StringBuilder(respText)
    val replacementList = mutableListOf<ReplacementInfo>()
    var offset = 0
    for (match in matches) {
        val replacementText = match.matchedText + "(" + match.word.chinese + ")"
        val currentStartPos = match.startPosition + offset
        val currentEndPos = match.endPosition + offset
        result.replace(currentStartPos, currentEndPos, replacementText)
        replacementList.add(
            ReplacementInfo(
                match.matchedText,
                replacementText,
                currentStartPos,
                currentStartPos + replacementText.length
            )
        )
        offset += replacementText.length - match.matchedText.length
    }
    replacementList.sortWith(Comparator {
        o1, o2 -> o1.startPosition - o2.startPosition
    })
    return ProcessedResult(result.toString(), replacementList)
}

fun main() {
    val replyText = "Hi, I'm Tom.I'm from icarbonx,welcome to icarbonx!Nice to meet you!"
    val wordList = listOf<Word>(Word("icarbonx", "硅基生命"), Word("Nice to meet you", "很高兴见到你"))
    val processedResult = process(replyText, wordList)
    println(processedResult)

    val respText = "It's sunny today! How's the weather on your planet?"
    val words = listOf<Word>(Word("planet", "星球"), Word("sunny", "晴朗"))
    val result = process2(respText, words)
    println(result)

    val result2 = process3(respText, words)
    println(result2)

    val respText2 = "It's New York! What about your new clothes?"
    val words2 = listOf<Word>(Word("new", "新的"), Word("New York", "纽约"))
    val result3 = process3(respText2, words2)
    println(result3)
}