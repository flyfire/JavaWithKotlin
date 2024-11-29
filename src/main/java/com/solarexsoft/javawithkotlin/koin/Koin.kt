package com.solarexsoft.javawithkotlin.koin

import java.lang.IllegalArgumentException
import kotlin.reflect.KClass


/*
 * Created by Solarex on 2024/11/08 11:25
 */
class CircularDependencyException(message: String) : Exception(message)
class Koin {

    companion object {
        fun create(configuration: Koin.() -> Unit): Koin {
            return Koin().apply(configuration)
        }
    }
    data class Definition<T>(
        val factory: Koin.() -> T,
        val isSingleton: Boolean
    )

    val definitions = mutableMapOf<KClass<*>, Definition<*>>()
    private val singletons = mutableMapOf<KClass<*>, Any>()
    private val beingCreated = mutableSetOf<KClass<*>>()

    inline fun <reified T : Any> single(noinline definition: Koin.() -> T) {
        definitions[T::class] = Definition(definition, true)
    }

    inline fun <reified T : Any> factory(noinline definition: Koin.() -> T) {
        definitions[T::class] = Definition(definition, false)
    }

    fun <T : Any> get(clazz: KClass<T>): T {
        val definition =
            definitions[clazz] ?: throw IllegalArgumentException("No definition found for ${clazz.simpleName}")
        if (beingCreated.contains(clazz)) {
            val dependencyChain = beingCreated.joinToString(" -> ") {
                it.simpleName ?: "Unknown"
            }
            throw CircularDependencyException("Circular dependency detected: $dependencyChain -> ${clazz.simpleName}")
        }
        if (definition.isSingleton && clazz in singletons) {
            return singletons[clazz] as T
        }
        try {
            beingCreated.add(clazz)
            val instance = if (definition.isSingleton) {
                singletons.getOrPut(clazz) { definition.factory(this)!! }
            } else {
                definition.factory(this)
            }
            return instance as T
        } finally {
            beingCreated.remove(clazz)
        }
    }

    fun clear() {
        definitions.clear()
        singletons.clear()
        beingCreated.clear()
    }
}

inline fun <reified T: Any> Koin.get(): T = get(T::class)