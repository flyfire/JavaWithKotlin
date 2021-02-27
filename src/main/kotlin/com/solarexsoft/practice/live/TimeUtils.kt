package com.solarexsoft.practice.live

import java.math.BigDecimal
import java.math.RoundingMode
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.ceil
import kotlin.math.floor

object TimeUtils {

    const val ONE_SECOND: Long = 1000
    const val ONE_MINUTE = 60 * ONE_SECOND
    const val ONE_HOUR = 60 * ONE_MINUTE
    const val ONE_DAY = 24 * ONE_HOUR
    const val ONE_WEEK = 7 * ONE_DAY
    private const val ONE_MONTH = 30 * ONE_DAY
    private const val ONE_YEAR = 12 * ONE_MONTH

    const val YEAR_MONTH_DAY = "yyyy年MM月dd日"
    const val DASH_YEAR_MONTH_DAY = "yyyy-MM-dd"
    const val YEAR_MONTH_DAY_HOUR_MIN = "yyyy年MM月dd日 HH:mm"
    const val DASH_YEAR_MONTH_DAY_HOUR_MIN = "yyyy-MM-dd HH:mm"
    const val HOUR_MIN = "HH:mm"
    const val MONTH_DAY_HOUR_MIN = "MM月dd日 HH:mm"
    const val DOT_MONTH_DAY = "MM.dd"
    private val DATE_FORMATTER = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

    private val reusableBuilder = StringBuilder()

    /**
     * 将毫秒转成 minute : second 的字符串，兼容大于一小时的情况
     */
    fun parse2HMS(ms: Long): String {
        if (ms < 0) {
            return "00:00"
        }
        return if (ms < ONE_HOUR) {
            String.format(
                "%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(ms) % TimeUnit.HOURS.toMinutes(1),
                TimeUnit.MILLISECONDS.toSeconds(ms) % TimeUnit.MINUTES.toSeconds(1)
            )
        } else String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(ms),
            TimeUnit.MILLISECONDS.toMinutes(ms) % TimeUnit.HOURS.toMinutes(1),
            TimeUnit.MILLISECONDS.toSeconds(ms) % TimeUnit.MINUTES.toSeconds(1)
        )
    }

    /**
     * 解析服务端返回的 second : nano 时间格式
     */
    fun parseTime(string: String?): Date {
        if (null == string || string.isEmpty()) {
            return Date()
        }
        val strs = string.split(":")
        return try {
            val millisecond = TimeUnit.SECONDS.toMillis(strs[0].toLong())
            val nano = strs[1].toInt()
            val ts = Timestamp(millisecond)
            ts.nanos = nano
            ts
        } catch (e: Exception) {
            Date()
        }
    }

    fun formatDate(date: Date?): String {
        return if (date == null) {
            ""
        } else DATE_FORMATTER.format(date)
    }

    fun calcDisplayTime(t: Date?): String {
        if (t == null) {
            return ""
        }
        return calcDisplayTime(t.time)
    }

    fun calcDisplayTime(timeMills: Long): String {
        var time = System.currentTimeMillis() - timeMills

        // Ensure it's not a negative time.
        if (time < 0) {
            time = 0
        }

        if (time < ONE_MINUTE) {
            return "刚刚"
        }

        when {
            time < ONE_HOUR -> {
                reusableBuilder.append(time / ONE_MINUTE)
                reusableBuilder.append("分钟")
            }
            time < ONE_DAY -> {
                reusableBuilder.append(time / ONE_HOUR)
                reusableBuilder.append("小时")
            }
            time < ONE_MONTH -> {
                reusableBuilder.append(time / ONE_DAY)
                reusableBuilder.append("天")
            }
            time < ONE_YEAR -> {
                reusableBuilder.append(time / ONE_MONTH)
                reusableBuilder.append("个月")
            }
            else -> {
                reusableBuilder.append(time / ONE_YEAR)
                reusableBuilder.append("年")
            }
        }

        reusableBuilder.append("前")

        val result = reusableBuilder.toString()
        reusableBuilder.delete(0, reusableBuilder.length)
        return result
    }

    fun calcDisplayTimeLength(leftTime: Long?): String {

        // Ensure it's not a negative time.
        var time = leftTime?.toDouble()
        if (time == null || time < 0) {
            time = 0.0
        }

        when {
            time < ONE_MINUTE -> {
                reusableBuilder.append(ceil(time / ONE_SECOND).toInt())
                reusableBuilder.append("秒")
            }
            time < ONE_HOUR -> {
                reusableBuilder.append(ceil(time / ONE_MINUTE).toInt())
                reusableBuilder.append("分钟")
            }
            time < ONE_DAY -> {
                reusableBuilder.append(ceil(time / ONE_HOUR).toInt())
                reusableBuilder.append("小时")
            }
            time < ONE_MONTH -> {
                reusableBuilder.append(time.toInt() / ONE_DAY)
                reusableBuilder.append("天")
            }
            time < ONE_YEAR -> {
                reusableBuilder.append(time.toInt() / ONE_MONTH)
                reusableBuilder.append("月")
            }
            else -> {
                reusableBuilder.append(time.toInt() / ONE_YEAR)
                reusableBuilder.append("年")
            }
        }

        val result = reusableBuilder.toString()
        reusableBuilder.delete(0, reusableBuilder.length)
        return result
    }

    fun calcDisplayTimePoint(t: Date?, includePeriod: Boolean = true): String {
        if (t == null) {
            return ""
        }

        val time = Calendar.getInstance()
        time.time = t

        val now = Calendar.getInstance()
        now.time = Date()

        when {
            time.get(Calendar.YEAR) != now.get(Calendar.YEAR) -> reusableBuilder.append("yyyy年M月d日 ")
            now.get(Calendar.DAY_OF_YEAR) - time.get(Calendar.DAY_OF_YEAR) > 1 -> reusableBuilder.append("M月d日 ")
            now.get(Calendar.DAY_OF_YEAR) - time.get(Calendar.DAY_OF_YEAR) == 1 -> reusableBuilder.append("昨天 ")
            now.get(Calendar.DAY_OF_YEAR) - time.get(Calendar.DAY_OF_YEAR) == -1 -> reusableBuilder.append("明天 ")
            now.get(Calendar.DAY_OF_YEAR) - time.get(Calendar.DAY_OF_YEAR) < -1 -> reusableBuilder.append("M月d日 ")
        }

        val h = time.get(Calendar.HOUR_OF_DAY)

        if (includePeriod) {
            when (h) {
                in 0..5 -> reusableBuilder.append("凌晨")
                in 6..11 -> reusableBuilder.append("早上")
                in 12..12 -> reusableBuilder.append("中午")
                in 13..17 -> reusableBuilder.append("下午")
                else -> reusableBuilder.append("晚上")
            }
            reusableBuilder.append("hh:mm")
        } else {
            reusableBuilder.append("HH:mm")
        }

        val result = getFormattedDate(reusableBuilder.toString(), t)
        reusableBuilder.delete(0, reusableBuilder.length)
        return result
    }

    fun calcDayOffset(oldDate: Long, newDate: Long): Int {
        return ((newDate - oldDate) / ONE_DAY).toInt()
    }

    fun calcTotalDate(t: Date?): String {
        if (t == null) {
            return ""
        }

        val reusableBuilder = StringBuilder()

        val time = Calendar.getInstance()
        time.time = t
        reusableBuilder.append("yyyy-MM-dd HH:mm:ss")
        return getFormattedDate(reusableBuilder.toString(), t)
    }

    fun calcSimpleDate(t: Date?): String {
        if (t == null) {
            return ""
        }

        val reusableBuilder = StringBuilder()

        val time = Calendar.getInstance()
        time.time = t
        reusableBuilder.append("yyy-MM-dd")
        return getFormattedDate(reusableBuilder.toString(), t)
    }

    fun calcCustomData(t: Date, format: String): String {
        val time = Calendar.getInstance()
        time.time = t
        reusableBuilder.append(format)
        val result = getFormattedDate(reusableBuilder.toString(), t)
        reusableBuilder.delete(0, reusableBuilder.length)
        return result
    }

    fun calcTotalDateTime(t: Date?): String {
        if (t == null) {
            return ""
        }

        val reusableBuilder = StringBuilder()

        val time = Calendar.getInstance()
        time.time = t
        reusableBuilder.append("yyyy年M月d日 HH:mm")
        return getFormattedDate(reusableBuilder.toString(), t)
    }

    fun calcChatListTimePoint(t: Date?): String {
        if (t == null) {
            return ""
        }

        val time = Calendar.getInstance()
        time.time = t

        val now = Calendar.getInstance()
        now.time = Date()

        when {
            time.get(Calendar.YEAR) != now.get(Calendar.YEAR) -> reusableBuilder.append("yyyy-M-d ")
            now.get(Calendar.DAY_OF_YEAR) == time.get(Calendar.DAY_OF_YEAR) -> reusableBuilder.append("HH:mm")
            now.get(Calendar.DAY_OF_YEAR) - time.get(Calendar.DAY_OF_YEAR) == 1 -> reusableBuilder.append("昨天 HH:mm")
            now.get(Calendar.WEEK_OF_YEAR) == time.get(Calendar.WEEK_OF_YEAR) -> reusableBuilder.append("EEEE HH:mm")
            else -> reusableBuilder.append("M-d HH:mm")
        }

        val result = getFormattedDate(reusableBuilder.toString(), t)
        reusableBuilder.delete(0, reusableBuilder.length)
        return result
    }

    fun getFormattedDate(template: String, date: Date?): String {
        if (date == null) {
            return ""
        }
        val simpleDateFormat = SimpleDateFormat(template, Locale.CHINA)
        simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT+8")
        return simpleDateFormat.format(date)
    }

    fun beforeYesterday(time: Long): Boolean {
        return System.currentTimeMillis() - time > ONE_DAY
    }

    fun beforeTwodaysAgo(time: Long): Boolean {
        return time == 0L || System.currentTimeMillis() - time > ONE_DAY * 2
    }

    fun before45hoursAgo(time: Long): Boolean {
        return time == 0L || System.currentTimeMillis() - time > ONE_HOUR * 45
    }

    fun beforeAWeekAgo(time: Long): Boolean {
        return System.currentTimeMillis() - time > ONE_WEEK
    }

    fun isTheSameDay(t: Long): Boolean {
        val time = Calendar.getInstance()
        time.timeInMillis = t
        val now = Calendar.getInstance()
        return time.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR)
    }

    fun isTheSameDay(compareTime: Long, nowTime: Long): Boolean {
        val time = Calendar.getInstance()
        time.timeInMillis = compareTime
        val now = Calendar.getInstance()
        now.timeInMillis = nowTime
        return time.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR)
    }

    fun now(): Date {
        return Calendar.getInstance().time
    }

    fun mills2second(mills: Long): Int {
        return ceil((mills.toFloat() / ONE_SECOND).toDouble()).toInt()
    }

    fun mills2minuteFloor(mills: Long): Int {
        return floor((mills.toDouble() / ONE_MINUTE)).toInt()
    }

    fun millis2DayFromNow(mills: Long): Int {
        return ceil(((mills - System.currentTimeMillis()).toDouble()) / ONE_DAY).toInt()
    }

    /**
     * 将毫秒转为 X.XX 格式的分钟数，四舍五入
     */
    fun mills2minuteHalfUp(mills: Long, scale: Int? = 1): Float {
        return BigDecimal(mills.toDouble() / ONE_MINUTE).setScale(scale ?: 1, RoundingMode.HALF_UP).toFloat()
    }

    fun getTimeDifferance(start: Long, end: Long): String {
        val day = ((end - start) / (24 * 3600 * 1000)).toInt()
        val hour = ((end - start) % (24 * 3600 * 1000) / (3600 * 1000)).toInt()
        val min = ((end - start) % (3600 * 1000) / (60 * 1000)).toInt()
        return day.toString() + "天 ：" + hour + "时 ：" + min + "分"
    }
}

fun main() {
    print(TimeUtils.millis2DayFromNow(1565959334000))
}