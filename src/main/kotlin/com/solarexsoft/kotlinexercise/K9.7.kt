package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/9.
 * Desc:
 */
object TestMutable {
    val list = listOf<Int>(1, 2, 3)
}

open class SingletonHolder<out T, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        return instance ?: synchronized(this) {
            instance ?: creator!!(arg).also { instance = it }
        }
    }
}