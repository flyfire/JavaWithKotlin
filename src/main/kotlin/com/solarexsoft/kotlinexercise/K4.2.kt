package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
interface Driver{
    fun drive()
}

interface Writer{
    fun write()
}

class Manager:Driver,Writer{
    override fun drive() {
        println("低级经理在开车")
    }

    override fun write() {
        println("低级经理在写工作报告")
    }
}

class SeniorManager(val driver: Driver, val writer: Writer):Driver by driver, Writer by writer{

}

class CarDriver:Driver{
    override fun drive() {
        println("司机在开车")
    }
}
class Employee:Writer{
    override fun write() {
        println("秘书在写工作汇报")
    }
}

fun main(args: Array<String>) {
    val carDriver = CarDriver()
    val employee = Employee()
    val seniorManager = SeniorManager(carDriver, employee)
    seniorManager.drive()
    seniorManager.write()
}