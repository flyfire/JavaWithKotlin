package com.solarexsoft.kotlinexercise

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor


/**
 * Created by Solarex at 7:29 PM/3/6/21
 * Desc:
 */
data class Group(val id: Int, val name: String)
data class Person(val id: Int, val name: String, val group: Group)

fun <T: Any> T.deepCopy(): T {
    if (!this::class.isData) {
        return this
    }
    return this::class.primaryConstructor!!.let { primaryConstructor ->
        primaryConstructor.parameters.map { parameter ->
            val value = (this::class as KClass<T>).memberProperties.first { it.name == parameter.name }
                    .get(this)
            if ((parameter.type.classifier as? KClass<*>)?.isData == true) {
                parameter to value?.deepCopy()
            } else {
                parameter to value
            }
        }.toMap().let(primaryConstructor::callBy)
    }
}

fun main() {
    val group = Group(1, "android")
    val person = Person(0, "solarex", group)

    val copiedPerson = person.copy()
    val deepCopiedPerson = person.deepCopy()
    println(person === copiedPerson)
    println(person === deepCopiedPerson)

    println(person.group === copiedPerson.group)
    println(person.group === deepCopiedPerson.group)
}