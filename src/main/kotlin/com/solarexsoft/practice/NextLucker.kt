package com.solarexsoft.practice

import java.util.*

/**
 * Created by Solarex on 2020/8/26/2:20 PM
 * Desc:
 */
fun main(args: Array<String>) {
    val allPeople = listOf<String>("教授", "侯茹厚", "余秋波", "朱奕豪", "兰怡芳", "黄文忠")
    val sharedPeople = listOf<String>("侯茹厚", "兰怡芳")
    val people = allPeople - sharedPeople
    val index = Random().nextInt(people.size)
    println("恭喜${people[index]}为我们提供下一次分享")
}