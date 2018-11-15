package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/9.
 * Desc:
 */
object TestMutable {
    val list = listOf<Int>(1, 2, 3)
}

open class SingletonHolder<out T, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        return instance ?: synchronized(this) {
            instance ?: creator!!(arg).also { instance = it }
        }
    }
}

class Context
class DBManager private constructor(context: Context) {
    init {
        println("DBManager initialized")
    }
    companion object : SingletonHolder<DBManager, Context>(::DBManager)

    fun insert() {
        println("insert data into db")
    }

    fun delete() {
        println("delete data from db")
    }
}

fun main(args: Array<String>) {
    val context = Context()
    DBManager.getInstance(context).insert()
    DBManager.getInstance(context).insert()
    DBManager.getInstance(context).delete()
}