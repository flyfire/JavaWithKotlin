package com.solarexsoft.practice

import kotlin.reflect.KClass

/**
 * Created by Solarex on 3/3/21/11:02 AM
 * Desc:
 */
sealed class Page<out P : PageParam> {

    object SuperVip : Page<PageParam.Source>() {
        override fun jump(p: PageParam.Source) {
            println(p)
        }
    }

    object Learning : Page<PageParam.Multi>() {
        override fun jump(p: PageParam.Multi) {
            println(p)
        }
    }

    fun jump(map: Map<KClass<out Page<@UnsafeVariance P>>, () -> @UnsafeVariance P>) {

    }

    abstract fun jump(p: @UnsafeVariance P)
}

sealed class PageParam {
    class Source(source: String) : PageParam()
    class Multi(content: String, url: String) : PageParam()
}