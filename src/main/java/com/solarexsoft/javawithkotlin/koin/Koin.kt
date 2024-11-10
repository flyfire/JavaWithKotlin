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
    private var currentParameters: Map<String, Any> = emptyMap()

    fun <T : Any> register(clazz: Class<T>, definition: BeanDefinition<T>) {
        definitions[clazz] = definition as BeanDefinition<*>
    }

    fun <T : Any> get(clazz: Class<T>, parameters: Map<String, Any> = emptyMap()): T {
        if (creatingStack.contains(clazz)) {
            throw IllegalStateException("circular dependency detected: ${creatingStack.joinToString { " -> " }} -> ${clazz.name}")
        }
        val oldParameters = currentParameters
        try {
            creatingStack.add(clazz)

            val paramsToUse = if (parameters.isEmpty()) currentParameters else parameters

            if (definitions[clazz]?.isSingleton == true && instances.containsKey(clazz)) {
                return instances[clazz] as T
            }

            val definition = definitions[clazz] ?: throw IllegalStateException("No definition found for ${clazz.name}")

            val instance = (definition.factory as KoinContext.(Map<String, Any>) -> T).invoke(this, paramsToUse)

            if (definition.isSingleton) {
                instances[clazz] = instance
            }

            return instance
        } finally {
            creatingStack.removeLast()
            currentParameters = oldParameters
        }
    }

    fun clear() {
        definitions.clear()
        instances.clear()
        creatingStack.clear()
    }
}

class Module {
    val definitions = mutableListOf<Pair<Class<*>, BeanDefinition<*>>>()

    inline fun <reified T : Any> single(noinline definition: KoinContext.(Map<String, Any>) -> T) {
        definitions.add(T::class.java to BeanDefinition(definition, true))
    }

    inline fun <reified T : Any> factory(noinline definition: KoinContext.(Map<String, Any>) -> T) {
        definitions.add(T::class.java to BeanDefinition(definition, false))
    }
}

class Koin {
    val context = KoinContext()

    fun startKoin(vararg modules: com.solarexsoft.javawithkotlin.koin.Module) {
        modules.forEach { module ->
            module.definitions.forEach {  (clazz, definition) ->
                context.register(clazz as Class<Any>, definition as BeanDefinition<Any>)
            }
        }
    }

    inline fun <reified T : Any> get(vararg parameters: Pair<String, Any>) : T {
        return context.get(T::class.java, parameters.toMap())
    }
}

object GlobalKoin {
    val koin = Koin()

    fun startKoin(vararg modules: com.solarexsoft.javawithkotlin.koin.Module) = koin.startKoin(*modules)

    inline fun <reified T: Any> get(vararg parameters: Pair<String, Any>): T = koin.get(*parameters)
}

inline fun <reified T : Any> KoinContext.get(vararg parameters: Pair<String, Any>): T {
    return get(T::class.java, parameters.toMap())
}

data class Config(val url: String)
class Repository(private val config: Config)
class Service(private val repository: Repository)
class Controller(
    private val service: Service,
    private val debugMode: Boolean
)

fun main() {
    val myModule = Module().apply {
        single { params ->
            println("creating Config with parameters: $params")
            Config(params["baseUrl"] as String)
        }

        single { params ->
            println("creating Repository with parameters: $params")
            Repository(get())
        }

        single { params ->
            println("creating Service with parameters: $params")
            Service(get())
        }

        single { params ->
            println("creating Controller with parameters: $params")
            Controller(
                service = get(),
                debugMode = params["debug"] as? Boolean ?: false
            )
        }
    }

    GlobalKoin.startKoin(myModule)

    val controller = GlobalKoin.get<Controller>(
        "baseUrl" to "https://www.goolge.com",
        "debugMode" to true
    )

    println("Controller created: $controller")
}