package com.solarexsoft.kotlininaction

import java.lang.IllegalArgumentException
import kotlin.reflect.KClass

/**
 * Created by houruhou on 2018/11/2.
 * Desc:
 */
interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String): Boolean = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int): Boolean = input >= 0
}

object Validators {
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    /*
    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator
    }*/

    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> = validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("no validator for ${kClass.simpleName}")

    operator fun <T : Any> set(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator
    }
}

fun main(args: Array<String>) {
    Validators[String::class] = DefaultStringValidator
    Validators[Int::class] = DefaultIntValidator

    println(Validators[Int::class].validate(1))
    println(Validators[String::class].validate("abc"))
}