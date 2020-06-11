package com.solarexsoft.practice

import com.fasterxml.jackson.databind.ObjectMapper
import jdk.nashorn.internal.ir.annotations.Ignore
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created by Solarex on 2020/6/11/10:42 AM
 * Desc:
 */
class SubtitleWords {
}
fun main(args: Array<String>) {
    val resourceAsStream = SubtitleWords::class.java.classLoader.getResourceAsStream("preview")
    val br = BufferedReader(InputStreamReader(resourceAsStream!!))
    val line = br.readLine()
    println(line)
    val objectMapper = ObjectMapper()
    val rsp = objectMapper.readValue(line, Rsp::class.java)
    println(rsp)
}

data class Error(val code: Int = 0, val message: String = "")
data class Rsp(val error: Error? = null, val data: PracticeDetail? = null)
data class PracticeInfo(
        var practiceId: String = "",
        var videoInfo: PracticeVideoInfo? = null
)

data class PracticeVideoInfo(
        var videoSectionId: String = "",
        var title: String = "",
        var url: String = "",
        var lowResolutionUrl: String = "",
        var coverUrl: String = "",
        var subtitles: List<Subtitles>? = null,
        var size: Size? = null,
        var during: Long = 0,
        var subtitlePattern: String = "",
        var shareCoverUrl: String = "",
        var currentSubtitleId: String = "",
        var listeningPracticeMode: String = "",
        var coverThumbnailUrl: String = "",
        var audioUrl: String = "",
        var promotionAudioUrl: String = "",
        var nickName: String = "",
        var uploaderId: String = "",
        var useMachineTranslation: Boolean = false,
        var vip: Boolean = false,
        var avatarUrl: String = "",
        var newTitle: String = "",
        var worksName: String = ""
)

data class Subtitles(
        val subtitleId: String = "",
        val englishContent: String = "",
        val chineseContent: String = "",
        val seekStart: Long = 0,
        val seekEnd: Long = 0,
        var hasNote: Boolean = false,
        val videoUrl: String = "",
        var audioUrl: String = "",
        var listeningCount: Int = 0,
        val supportSpeakingPractice: Boolean = true,
        var skip: Boolean = false, //replace supportSpeakingPractice
        @Transient var markWords: ArrayList<MarkWord> = arrayListOf(),
        @Transient val learningWords: ArrayList<MarkWord> = arrayListOf(),
        @Transient val importantWords: ArrayList<MarkWord> = arrayListOf(),
        @Transient val subtitleWords: List<SubtitleMarkWord> = emptyList(),
        var playCount: Int = 0
)

data class MarkWord(
        var wordId: String = "",
        val markStart: Int = 0,
        val markEnd: Int = 0,
        //native
        var color: Int = 0
)

data class SubtitleMarkWord(
        val name: String = "",
        val positions: List<MarkPosition> = emptyList()
)

data class Size(
        val width: Int = 0,
        val height: Int = 0
)

data class MarkPosition(
        val seekStart: Int = 0,
        val seekEnd: Int = 0
)

data class PracticeDetail(
        var practiceInfo: PracticeInfo? = null,
        var likeCount: Long = 0,
        var commentCount: Long = 0,
        var shareCount: Long = 0,
        var liked: Boolean = false,
        var shared: Boolean = false,
        var courseId: String = "",
        var vip: Boolean = false,
        var tags: List<SimpleTagInfo> = emptyList(),
        var learningTypes: List<String> = emptyList(),
        val unfinishedModule: String = "",
        val unfinished: Boolean = false,
        val unfinishedType: String = "",
        val speakingPracticeModes: List<String> = emptyList(),
        val nextVideoSectionId: String? = null,
        val isBuy: Boolean = false,
        val minGuidCount: Int = 3,
        val trainBuyUrl: String = "",
        val topicSubtitles: List<VIPTopicSubtitle> = emptyList(),
        val showRegistrationReward: Boolean = false,
        val videoShareType: String = ""
)

data class SimpleTagInfo(
        val id: String = "",
        val name: String = ""
)
data class VIPTopicSubtitle(
        val subtitleId: String = "",
        val englishContent: String = "",
        val audioUrl: String = "",
        var index: Int = 0 // user
)