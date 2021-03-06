package com.solarexsoft.kotlinexercise

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty0
import kotlin.reflect.jvm.isAccessible

/**
 * Created by Solarex at 9:37 PM/3/6/21
 * Desc:
 */
class Bitmap(val width: Int, val height: Int)

class ReleasableNotNull<T: Any>: ReadWriteProperty<Any, T> {
    private var value: T? = null

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        this.value = value
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("Not initialized or release already")
    }

    fun isInitialized() = value != null
    fun release() {
        value = null
    }
}

fun <T: Any> releasableNotNull() = ReleasableNotNull<T>()

inline val KProperty0<*>.isInitialized: Boolean
    get() {
        isAccessible = true
        return (getDelegate() as? ReleasableNotNull<*>)?.isInitialized() ?: throw IllegalAccessException("Delegate is not an instance of ReleasableNotNull")
    }

fun KProperty0<*>.release() {
    isAccessible = true
    (getDelegate() as? ReleasableNotNull<*>)?.release()
}


class Activity {
    private var bitmap by releasableNotNull<Bitmap>()

    fun onCreate() {
        println(this::bitmap.isInitialized)
        bitmap = Bitmap(1920, 1680)
        println(this::bitmap.isInitialized)
    }

    fun onDestroy() {
        println(this::bitmap.isInitialized)
        this::bitmap.release()
        println(this::bitmap.isInitialized)
    }
}

fun main() {
    val activity = Activity()
    activity.onCreate()
    activity.onDestroy()
}