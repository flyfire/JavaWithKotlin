package com.solarexsoft.practice.live

import com.google.gson.Gson

/**
 * Created by Solarex on 12/24/20/4:56 PM
 * Desc:
 */
fun main(args: Array<String>) {
    val tmp = mutableListOf<SmallCourseLiveLesson>()
    val teacherInfo1: LiveTeacherInfo = LiveTeacherInfo("Colin",
            "https://image.wu-mi.com/images/f/O/i/l6bkF7.png", "", "伯克利大学硕士")
    val teacherInfo2: LiveTeacherInfo = LiveTeacherInfo("Heidi",
            "https://image.wu-mi.com/images/f/u/P/USMUnk.png", "", "剑桥CELTA教师")
    val teacherInfo3: LiveTeacherInfo = LiveTeacherInfo("Cyrus",
            "https://image.wu-mi.com/images/f/B/8/Y8wGB.png", "", "澳洲国家级口译员")
    val teacherInfo4: LiveTeacherInfo = LiveTeacherInfo("Rachel",
            "https://image.wu-mi.com/images/f/J/T/hCFqvm.png", "", "剑桥大学硕士")
    tmp.add(SmallCourseLiveLesson(
            "4ZNrbdYJ",
            java.lang.System.currentTimeMillis(),
            "听力实战：精听大白的暖男对话",
            "",
            LiveLessonStatus.LIVING.name,
            "https://www.you-mi.net/m/live/lesson?id=4ZNrbdYJ",
            teacherInfo1,
            false,
            "https://image.wu-mi.com/image/convert/cDZ2rQh_j6Fcqo45yKqCsHLbGWyUs0Wt5PUT1NEE1mw/tvXUEC0e.qa_75~sl_1280,720.jpg",
            "",
            "A2初级",
            98,
            true))

    tmp.add(SmallCourseLiveLesson(
            "kBB73cKk",
            System.currentTimeMillis() + TimeUtils.ONE_HOUR* 8,
            "实境口语：国外找厕所还[WC]? 别让课本坑了你！",
            "",
            LiveLessonStatus.NOT_START.name,
            "https://www.you-mi.net/m/live/lesson?id=3TYdRTtd",
            teacherInfo2,
            false,
            "https://image.wu-mi.com/image/convert/LVLfpgrX_5gorjyvzZKiFbKafiFsBWG5C3DiYX4Pxxs/H6s51Km3.qa_75~sl_1280,720.jpg",
            "",
            "A2初级",
            98,
            true))

    tmp.add(SmallCourseLiveLesson(
            "3TYdRTtd",
            System.currentTimeMillis(),
            "实境口语：国外找厕所还[WC]? 别让课本坑了你！",
            "",
            LiveLessonStatus.LIVING.name,
            "https://www.you-mi.net/m/live/lesson?id=3TYdRTtd",
            teacherInfo1,
            false,
            "",
            "https://image.wu-mi.com/image/convert/wl5aZ-4OZsppoAnI1iYewHYgW569p3t9ArbgwATGov8/muKiIlk2.qa_75~sl_1280,720.jpg",
            "A2初级",
            98,
            false))

    tmp.add(SmallCourseLiveLesson(
            "ahACJix",
            System.currentTimeMillis() + TimeUtils.ONE_HOUR* 11,
            "实境口语：国外找厕所还[WC]? 别让课本坑了你！",
            "",
            LiveLessonStatus.NOT_START.name,
            "https://www.you-mi.net/m/live/lesson?id=ahACJix",
            teacherInfo2,
            false,
            "",
            "https://image.wu-mi.com/image/convert/fGw82xU9qnIZKUqCmp7FukOedE0zFQldYUAnK6wRuLg/Py4GQ8kC.qa_75~sl_1280,720.jpg",
            "A2初级",
            98,
            false))

    tmp.add(SmallCourseLiveLesson(
            "2w5xbv1x",
            System.currentTimeMillis() + TimeUtils.ONE_HOUR* 2,
            "实境口语：国外找厕所还[WC]? 别让课本坑了你！",
            "",
            LiveLessonStatus.NOT_START.name,
            "https://www.you-mi.net/m/live/lesson?id=2w5xbv1x",
            teacherInfo3,
            false,
            "",
            "https://image.wu-mi.com/image/convert/DwaRnQspkQ0ZJ4zzFmzHu49h2OCNT_rBKPsFBTohSf4/kVDLJeu7.qa_75~sl_1280,720.jpg",
            "B1中级",
            98,
            false))

    tmp.add(SmallCourseLiveLesson(
            "2w5xbv1x",
            System.currentTimeMillis() + TimeUtils.ONE_HOUR* 8,
            "实境口语：国外找厕所还[WC]? 别让课本坑了你！",
            "",
            LiveLessonStatus.FINISHED.name,
            "https://www.you-mi.net/m/live/lesson?id=2w5xbv1x",
            teacherInfo4,
            false,
            "",
            "https://image.wu-mi.com/image/convert/DwaRnQspkQ0ZJ4zzFmzHu49h2OCNT_rBKPsFBTohSf4/kVDLJeu7.qa_75~sl_1280,720.jpg",
            "A1初级",
            98,
            false))
    val str = Gson().toJson(tmp)
    println(str)
}