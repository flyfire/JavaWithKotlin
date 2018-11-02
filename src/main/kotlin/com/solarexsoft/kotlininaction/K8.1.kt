package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/11/1.
 * Desc:
 */
enum class Delivery { STANDARD, EXPEDITED}
class Order(val itemCount : Int)
fun getShippingCostCalculator(delivery: Delivery) : (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6+2.1*order.itemCount }
    }
    return {order -> 1.2 * order.itemCount}
}

fun main(args: Array<String>) {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping cost is ${calculator(Order(3))}")
}