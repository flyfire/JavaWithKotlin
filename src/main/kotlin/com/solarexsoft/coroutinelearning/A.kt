package com.solarexsoft.coroutinelearning

/**
 * Created by houruhou on 2020/4/9.
 * Desc:
 */
class A {
    fun init(initialize: A.() -> Unit) {
        initialize.invoke(this)
    }
}