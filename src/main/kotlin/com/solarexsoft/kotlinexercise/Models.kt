package com.solarexsoft.kotlinexercise

import java.util.concurrent.ConcurrentHashMap
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * Created by Solarex at 5:38 PM/3/6/21
 * Desc:
 */
abstract class AbsModel {
    init {
        Models.run {
            register()
        }
    }
}

class DatabaseModel: AbsModel() {
    fun query(sql: String): Int = 0
}

class NetworkModel: AbsModel() {
    fun get(url: String): String = """{"code" : 0}"""
}

fun initModels() {
    DatabaseModel()
    NetworkModel()
}

object Models {
    private val modelMap = ConcurrentHashMap<Class<out AbsModel>, AbsModel>()

    fun AbsModel.register() {
        modelMap[this.javaClass] = this
    }

    fun <T: AbsModel> KClass<T>.get(): T {
        return modelMap[this.java] as T
    }
}

class MainViewModel {
    val databaseModel by ModelDelegate(DatabaseModel::class)
    val networkModel by ModelDelegate(NetworkModel::class)
}

class ModelDelegate<T: AbsModel>(val kClass: KClass<T>): ReadOnlyProperty<Any, T> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return Models.run {
            kClass.get()
        }
    }
}

fun main() {
    initModels()
    val mainViewModel = MainViewModel()
    mainViewModel.databaseModel.query("select * from student").let(::println)
    mainViewModel.networkModel.get("https://flyfire.github.io").let(::println)
}