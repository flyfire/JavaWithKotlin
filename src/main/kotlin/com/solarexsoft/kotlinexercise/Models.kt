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

class SpModel: AbsModel() {
    init {
        Models.run {
            register("SpModel2")
        }
    }

    fun hello() = println("${hashCode()},solarex")
}

fun initModels() {
    DatabaseModel()
    NetworkModel()
    SpModel()
}

object Models {
    private val modelMap = ConcurrentHashMap<String, AbsModel>()

    fun AbsModel.register(name: String = this.javaClass.simpleName) {
        modelMap[name] = this
    }

    fun <T: AbsModel> String.get(): T {
        return modelMap[this] as T
    }
}

class MainViewModel {
//    val databaseModel by ModelDelegate(DatabaseModel::class)
//    val networkModel by ModelDelegate(NetworkModel::class)
    val databaseModel: DatabaseModel by ModelDelegate
    val networkModel: NetworkModel by ModelDelegate
    val spModel: SpModel by ModelDelegate
    val spModel2: SpModel by ModelDelegate
}

//class ModelDelegate<T: AbsModel>(val kClass: KClass<T>): ReadOnlyProperty<Any, T> {
//    override fun getValue(thisRef: Any, property: KProperty<*>): T {
//        return Models.run {
//            kClass.get()
//        }
//    }
//}
object ModelDelegate {
    operator fun <T: AbsModel> getValue(thisRef: Any, property: KProperty<*>): T {
        return Models.run {
            property.name.capitalize().get()
        }
    }
}

fun main() {
    initModels()
    val mainViewModel = MainViewModel()
    mainViewModel.databaseModel.query("select * from student").let(::println)
    mainViewModel.networkModel.get("https://flyfire.github.io").let(::println)
    mainViewModel.spModel.hello()
    mainViewModel.spModel2.hello()
}