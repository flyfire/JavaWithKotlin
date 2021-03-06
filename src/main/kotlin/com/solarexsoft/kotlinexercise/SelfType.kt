package com.solarexsoft.kotlinexercise

/**
 * Created by Solarex at 5:14 PM/3/6/21
 * Desc:
 */
typealias OnConfirm = () -> Unit
typealias OnCancel = () -> Unit

private val EmptyFunction = {}

open class Notification(
        val title: String,
        val content: String
)

class ConfirmNotification(
        title: String,
        content: String,
        val onConfirm: OnConfirm,
        val onCancel: OnCancel
) : Notification(title, content)

open class NotificationBuilder {
    protected var title: String = ""
    protected var content: String = ""

    fun title(title: String): NotificationBuilder {
        this.title = title
        return this
    }

    fun content(content: String): NotificationBuilder {
        this.content = content
        return this
    }

    open fun build() = Notification(title, content)
}

class ConfirmNotificationBuilder: NotificationBuilder() {
    private var onConfirm: OnConfirm = EmptyFunction
    private var onCancel: OnCancel = EmptyFunction

    fun onConfirm(onConfirm: OnConfirm): ConfirmNotificationBuilder {
        this.onConfirm = onConfirm
        return this
    }

    fun onCancel(onCancel: OnCancel): ConfirmNotificationBuilder {
        this.onCancel = onCancel
        return this
    }

    override fun build() = ConfirmNotification(title, content, onConfirm, onCancel)
}

interface SelfType<Self> {
    val self: Self
        get() = this as Self
}

fun main() {
    ConfirmNotificationBuilder()
            .title("Hello")

}