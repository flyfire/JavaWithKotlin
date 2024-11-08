package com.solarexsoft.javawithkotlin.koin

import java.lang.IllegalStateException


/*
 * Created by Solarex on 2024/11/08 11:25
 */
data class BeanDefinition<T : Any>(
    val factory: KoinContext.(Map<String, Any>) -> T,
    val isSingleton: Boolean = true
)

class KoinContext {
    private val definitions = mutableMapOf<Class<*>, BeanDefinition<*>>()
    private val instances = mutableMapOf<Class<*>, Any>()
    private val creatingStack = mutableListOf<Class<*>>()

    fun <T : Any> register(clazz: Class<T>, definition: BeanDefinition<T>) {
        definitions[clazz] = definition
    }

    fun <T : Any> get(clazz: Class<T>, parameters: Map<String, Any> = emptyMap()): T {
        if (creatingStack.contains(clazz)) {
            throw IllegalStateException("circular dependency detected: ${creatingStack.joinToString { " -> " }} -> ${clazz.name}")
        }
        try {
            creatingStack.add(clazz)

            if (definitions[clazz]?.isSingleton == true && instances.containsKey(clazz)) {
                return instances[clazz] as T
            }

            val definition = definitions[clazz] ?: throw IllegalStateException("No definition found for ${clazz.name}")

            val instance = (definition as BeanDefinition<T>).factory.invoke(this, parameters)

            if (definition.isSingleton) {
                instances[clazz] = instance
            }

            return instance
        } finally {
            creatingStack.removeLast()
        }
    }
}

class Module {
    val definitions = mutableListOf<Pair<Class<*>, BeanDefinition<*>>>()

    inline fun <reified T : Any> single(noinline definition: KoinContext.(Map<String, Any>) -> T) {
        definitions.add(T::class.java to BeanDefinition(definition, true))
    }

    inline fun <reified T : Any> factory(noinline defintion: KoinContext.(Map<String, Any>) -> T) {
        definitions.add(T::class.java to BeanDefinition(defintion, false))
    }
}