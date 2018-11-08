package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/8.
 * Desc:
 */
annotation class POJO

@Target(allowedTargets = arrayOf(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY))
annotation class FieldAnno