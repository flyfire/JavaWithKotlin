package com.solarexsoft.practice

import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject

/**
 * Created by Solarex on 3/3/21/11:02 AM
 * Desc:
 */
sealed class Page<out P : PageParam> {

    companion object {
        fun <T: PageParam> jump(map: Map<out Page<T>, () -> T>) {

        }
    }

    class SuperVip(type: String) : Page<PageParam.Source>() {
        override fun jump(p: PageParam.Source) {
            println(p)
        }
    }

    object Learning : Page<PageParam.Multi>() {
        override fun jump(p: PageParam.Multi) {
            println(p)
        }
    }

    abstract fun jump(p: @UnsafeVariance P)
}

sealed class PageParam {
    class Source(source: String) : PageParam()
    class Multi(content: String, url: String) : PageParam()
}

fun main() {
    val map = mutableMapOf<KClass<out Page<@kotlin.UnsafeVariance PageParam>>, () -> @kotlin.UnsafeVariance PageParam>()
    map[Page.SuperVip::class] = {
        PageParam.Source("feed_list")
    }
    map[Page.Learning::class] = {
        PageParam.Multi("hello", "https://www.baidu.com")
    }
    val superVip = Page.SuperVip("Oral")
    superVip.jump(map[superVip::class]())
}