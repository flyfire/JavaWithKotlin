package com.solarexsoft.kotlinexercise

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.StringBuilder
import java.lang.reflect.Proxy
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions
import kotlin.reflect.full.valueParameters

/**
 * Author: Solarex
 * Time: 22:22/2021/3/7
 */
data class User(
    val login: String,
    val location: String,
    val bio: String
)

data class Fork(
    val id: String,
    val owner: User,
    val html_url: String
)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class IApi(val url: String)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class Path(val url: String)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class Get(val url: String)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class PathVariable(val name: String)

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class Query(val name: String)

@IApi("https://api.github.com")
interface GithubApi {
    @IApi("users")
    interface Users {
        @Get("{name}")
        fun get(name: String): User

        @Get("{name}/followers")
        fun followers(name: String): List<User>
    }

    @IApi("repos")
    interface Repos {
        @Get("{owner}/{repo}/forks")
        fun forks(owner: String, repo: String): List<Fork>
    }
}

object RetrofitApi {
    const val PATH_PATTERN = """(\{(\w+)\})"""

    val okHttp = OkHttpClient()
    val gson = Gson()

    val enclosing = {
        cls: Class<*> ->
        var currentCls: Class<*>? = cls
        sequence<Class<*>> {
            while (currentCls != null) {
                yield(currentCls!!)
                currentCls = currentCls?.enclosingClass
            }
        }
    }

    inline fun <reified T> create(): T {
        val functionMap = T::class.functions.map { it.name to it }.toMap()
        val interfaces = enclosing(T::class.java).takeWhile { it.isInterface }.toList()


        val apiPath = interfaces.foldRight(StringBuilder()) {
            clazz, acc ->
            acc.append(clazz.getAnnotation(IApi::class.java)?.url?.takeIf { it.isNotEmpty() } ?: clazz.name)
                .append("/")
        }.toString()

        return Proxy.newProxyInstance(RetrofitApi.javaClass.classLoader, arrayOf(T::class.java)) {
            proxy, method, args ->
            functionMap[method.name]?.takeIf { it.isAbstract }?.let {
                kFunction ->
                val paramterMap = kFunction.valueParameters.map {
                    it.name to args[it.index - 1]
                }.toMap()

                val endPoint = kFunction.findAnnotation<Get>()!!.url.takeIf{ it.isNotEmpty() } ?: kFunction.name
                val compiledEndPoint = Regex(PATH_PATTERN).findAll(endPoint).map {
                    matchResult ->
                    matchResult.groups[1]!!.value to paramterMap[matchResult.groups[2]!!.value]
                }.fold(endPoint) {
                    acc, pair ->
                    acc.replace(pair.first, pair.second.toString())
                }

                val url = "${apiPath}${compiledEndPoint}"
                println(url)

                okHttp.newCall(Request.Builder().url(url).get().build()).execute().body()?.charStream()?.use {
                    gson.fromJson(JsonReader(it), method.genericReturnType)
                }
            }
        } as T
    }
}

fun main() {
    val reposApi = RetrofitApi.create<GithubApi.Repos>()
    reposApi.forks("dbacinski", "Design-Patterns-In-Kotlin").map {
        it.html_url
    }.forEach(::println)
    val usersApi = RetrofitApi.create<GithubApi.Users>()
    println(usersApi.get("flyfire"))
    println(usersApi.followers("flyfire").map {
        it.login
    })
}