package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/11/1.
 * Desc:
 */
data class SiteVisit(val path: String, val duration : Double, val os : OS)
enum class OS {WINDOWS, LINUX, MAC, IOS, ANDROID}

fun main(args: Array<String>) {
    val log = listOf<SiteVisit>(
            SiteVisit("/", 34.0, OS.WINDOWS),
            SiteVisit("/", 22.0, OS.LINUX),
            SiteVisit("/login", 12.0, OS.ANDROID),
            SiteVisit("/signup", 8.0, OS.MAC),
            SiteVisit("/", 16.3, OS.ANDROID)
    )

    fun List<SiteVisit>.averageDurationFor(predicate:(SiteVisit) -> Boolean) =
            filter(predicate).map(SiteVisit::duration).average()

    println(log.averageDurationFor { it.os in setOf<OS>(OS.ANDROID, OS.IOS) })
    println(log.averageDurationFor { it.os == OS.ANDROID && it.path == "/login" })
}