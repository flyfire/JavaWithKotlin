package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */

open class People(var character: String, var looking: String, var voice: String) {
    init {
        println("new a ${this.javaClass.simpleName},character is $character, looking is $looking, voice is $voice")
    }

    fun eat() {
        println("eating")
    }
}

class Girl(character: String,looking: String, voice: String):People(character, looking, voice) {
    init {
        println("new a girl")
    }


}

class Boy(character: String,looking: String, voice: String):People(character, looking, voice) {
    init {
        println("new a boy")
    }

    fun sing() {
        println("boy is sing")
    }
}


fun main(args: Array<String>) {
    val girl = Girl("温柔", "甜美", "动人")
    val boy = Boy("彪悍", "帅气", "浑厚")
    println(girl is People)
    println(boy is People)
    val a : People = Boy("彪悍", "帅气", "浑厚")

    if (a is Boy) {
        a.sing()
    }
}