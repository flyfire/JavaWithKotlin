package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/9.
 * Desc:
 */
val test = {
    println("solarex")
}
fun main(args: Array<String>) {
    val a = J9_4()
    val lambda = {
        println("hello,world")
    }
    /*
    a.addTask(lambda)
    a.addTask(lambda)
    a.addTask(lambda)
    a.addTask(lambda)
    a.removeTask(lambda)
    a.removeTask(lambda)
    a.removeTask(lambda)
    a.removeTask(lambda)
    */
    /*
    After add: com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@4617c264,we have 1 in all.
After add: com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@36baf30c,we have 2 in all.
After add: com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@7a81197d,we have 3 in all.
After add: com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@5ca881b5,we have 4 in all.
After remove com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@24d46ca6,only 4 left.
After remove com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@4517d9a3,only 4 left.
After remove com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@372f7a8d,only 4 left.
After remove com.solarexsoft.kotlinexercise.K9_4Kt$sam$java_lang_Runnable$0@2f92e0f4,only 4 left.
     */
    a.addTask(test)
    a.addTask(test)
    a.addTask(test)
    a.addTask(test)
    a.removeTask(test)
    a.removeTask(test)
    a.removeTask(test)
    a.removeTask(test)
    println(test::class)
    println(test)
}