package com.solarexsoft.coroutinelearning

import com.solarexsoft.javawithkotlin.User

/**
 * Created by houruhou on 2020/4/5.
 * Desc:
 */
object ExampleSingleton {
    val user : User by lazy {
        User(18, "solarex")
    }
}