package com.solarexsoft.kotlininaction

import java.io.File

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, true)
    }
}

class KKUser private constructor(val nickname: String) {
    companion object {
        fun newSubscirbeingUser(email: String) = KKUser(email.substringBefore("@"))
        fun newFacebookUser(id : Int) = KKUser("id:$id")
    }
}
fun main(args: Array<String>) {
    val files = listOf<File>(File("/Z"), File("/C"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
    println(files)

    val subscribingUser = KKUser.newSubscirbeingUser("a@b.com")
    println(subscribingUser.nickname)
    val facebookUser = KKUser.newFacebookUser(1)
    println(facebookUser.nickname)
}