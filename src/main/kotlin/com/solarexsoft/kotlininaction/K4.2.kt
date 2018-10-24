package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
class UserVerbose constructor(_nickname: Int) {
    var nickname: Int

    init {
        nickname = _nickname
        println("1-->" + nickname)
    }

    init {
        nickname = _nickname * 10
        println("2-->" + nickname)
    }
}

class Secretive private constructor() {}


class Context
class AttributeSet

open class SolarexView {
    constructor(ctx: Context) {
    }
    constructor(ctx: Context, attrs: AttributeSet) {}
}

class SolarexButton: SolarexView {
    constructor(ctx: Context): this(ctx, AttributeSet()){}
    constructor(ctx: Context, attrs: AttributeSet):super(ctx, attrs){}
}

interface SUser {
    val nickname: String
}

class PrivateUser(override val nickname:String) : SUser
class SubscribingUser(val email: String): SUser{
    override val nickname: String
        get() = email.substringBeforeLast("@")
}

interface TUser {
    val email: String
    val nickname: String
        get() = email.substringBefore("@")
}

class TTUser(val age: Int) : TUser {
    override val email: String
        get() = "rh.hou.work@gmail.com"
}

class TTTUser(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name:"$field" -> "$value".""".trimIndent())
            field = value
        }
        get() = field + " hahaha"
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val user = UserVerbose(10)
    //val secretive = Secretive()
    val me = TTUser(18)
    println("${me.email} ${me.nickname} ${me.age}")
    val hi = TTTUser("Solarex")
    hi.address = "America"
    println(hi.address)
    val count = LengthCounter()
    println(count.counter)
//    count.counter = 1

}