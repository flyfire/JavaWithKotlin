package com.solarexsoft.javawithkotlin.koin


/*
 * Created by Solarex on 2024/11/29 11:38
 */
interface MessageService {
    fun getMessage(): String
}
class SimpleMessageService(private val printer: MessagePrinter?): MessageService {
    override fun getMessage(): String = "hello from SimpleMessageService"
}

class MessagePrinter(private val messageService: MessageService) {
    fun printMessage() = println(messageService.getMessage())
}

fun normalUsage() {
    val koin = Koin.create {
        single<MessageService> { SimpleMessageService(null) }
        factory<MessagePrinter> { MessagePrinter(get()) }
    }

    val printer = koin.get<MessagePrinter>()
    printer.printMessage()
}

fun circleUsage() {
    try {
        val koin = Koin.create {
            single<MessageService> { SimpleMessageService(get())}
            factory<MessagePrinter> { MessagePrinter(get()) }
        }
        koin.get<MessagePrinter>()
    } catch (e: CircularDependencyException) {
        println("caught circular dependency exception: ${e.message}")
    }
}

fun main() {
    println("===========normal usage================")
    normalUsage()
    println("===========circle usage================")
    circleUsage()
}