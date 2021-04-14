package com.solarexsoft.kotlinexercise

open class Parent(open val list: List<Parent>)
class Child(override val list: List<Child>): Parent(list)