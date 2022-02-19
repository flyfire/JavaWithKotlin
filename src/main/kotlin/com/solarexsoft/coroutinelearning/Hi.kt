package com.solarexsoft.coroutinelearning

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Created by Solarex at 10:25/2020/5/16
 * Desc:
 */
fun test() {
    val a = Runnable { println("a") } // getstatic checkcast
    val b = object : Runnable {   // new dup invokespecial
        override fun run() {
            println("b")
        }
    }
    println(a::class.java)
    println(b::class.java)
    a.run()
    b.run()
}

fun main(args: Array<String>) {
    test()
    val dbPool = DBPool.getInstance(10)
    val runnable = Runnable {
        val connection = dbPool.acquire(500)
        if (connection != null) {
            println("${Thread.currentThread().name} acquire connection = $connection")
            Thread.sleep(1000)
            dbPool.release(connection)
            println("${Thread.currentThread().name} release connection = $connection")
        }
        println("${Thread.currentThread().name} acquire null")
    }

    val threadPoolExecutor = ThreadPoolExecutor(15, 15, 100, TimeUnit.MILLISECONDS, LinkedBlockingQueue<Runnable>())
    for (i in 0..50) {
        threadPoolExecutor.execute(runnable)
    }
    Thread.currentThread().join(10000)
    threadPoolExecutor.shutdownNow()
}

class Connection

open class SingletonHolder<Arg, Result>(initializer: (Arg) -> Result, lock: Any? = null) {
    private var initializer: ((Arg) -> Result)? = initializer

    @Volatile
    private var _value: Result? = null
    private val lock = lock ?: this
    fun getInstance(arg: Arg): Result {
        val _v1 = _value
        if (_v1 != null) {
            return _v1
        }
        return synchronized(lock) {
            val _v2 = _value
            if (_v2 != null) {
                _v2
            } else {
                _value = initializer!!.invoke(arg)
                initializer = null
                _value!!
            }
        }
    }
}

class DBPool(initCap: Int) {
    companion object : SingletonHolder<Int, DBPool>(::DBPool)

    private val poolList = mutableListOf<Connection>()
    private val lock = Object()

    init {
        for (i in 0..initCap) {
            poolList.add(Connection())
        }
    }

    fun release(connection: Connection) {
        synchronized(lock) {
            poolList.add(connection)
            lock.notifyAll()
        }
    }

    fun acquire(timeout: Long): Connection? {
        synchronized(lock) {
            if (timeout < 0L) {
                while (poolList.isEmpty()) {
                    lock.wait()
                }
                return poolList.removeFirst()
            } else {
                val future = System.currentTimeMillis() + timeout
                var remain = timeout
                while (poolList.isEmpty() && remain > 0L) {
                    lock.wait(remain)
                    remain = future - System.currentTimeMillis()
                }
                return if (poolList.isNotEmpty()) {
                    poolList.removeFirst()
                } else {
                    null
                }
            }
        }
    }
}
