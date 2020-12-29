package com.solarexsoft.practice.live

/**
 * Created by Solarex on 12/24/20/4:55 PM
 * Desc:
 */
data class SmallCourseLiveLesson(
        val lessonId: String = "",
        val publishingTime: Long = 0,
        val title: String = "",
        val category: String = "",
        val status: String = "",
        val landingPageUrl: String = "",
        val teacherInfo: LiveTeacherInfo? = null,
        val limitFree: Boolean = false,
        val trainImageUrl: String = "",
        val thumbnailUrl: String = "",
        val difficultyDescription: String = "",
        val matchDegree: Int = 0,
        val recommend: Boolean = false,
        // native
        var publishingTimeString: String = ""
)

data class LiveTeacherInfo(
        val nickName: String = "",
        val avatarImageUrl: String = "",
        val gender: String = "",
        val introduction: String = ""
)

enum class LiveLessonStatus {
    NOT_START,
    LIVING,
    FINISHED,
    CLOSE,

    // native
    PLAYBACK
}