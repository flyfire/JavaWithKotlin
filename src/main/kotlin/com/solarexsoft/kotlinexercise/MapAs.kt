package com.solarexsoft.kotlinexercise

import java.lang.IllegalArgumentException
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 * Created by Solarex at 7:45 PM/3/6/21
 * Desc:
 */
data class UserVO(val login: String, val avatar: String)
data class UserDTO(
        var id: Int,
        var login: String,
        var avatar: String,
        var url: String
)

fun main() {
    val userDTO = UserDTO(
            0,
            "solarex",
            "https://avatar.github.com/0.jpg",
            "https://github.com/flyfire"
    )
    val userVo: UserVO = userDTO.mapAs()
    println(userVo)

    val userMap = mapOf<String, Any>(
            "id" to 100,
            "login" to "flyfire",
            "avatar" to "https://avatar.github.com/100.jpg",
            "url" to "https://github.com/solarex"
    )
    val userVOFromMap: UserVO = userMap.mapAs()
    println(userVOFromMap)
}

inline fun <reified From: Any, reified To: Any> From.mapAs(): To {
    return To::class.primaryConstructor!!.let { primaryConstructor ->
        primaryConstructor.parameters.map { parameter ->
            val value = From::class.memberProperties.first { property -> property.name == parameter.name }
                    .get(this)
            parameter to value
        }.toMap().let(primaryConstructor::callBy)
    }
}

inline fun <reified To:Any> Map<String, Any?>.mapAs(): To {
    return To::class.primaryConstructor!!.let { primaryConstructor ->
        primaryConstructor.parameters.map { parameter ->
            val value = (this[parameter.name] ?: if (parameter.type.isMarkedNullable) null else throw IllegalArgumentException("${parameter.name} required not null"))
            parameter to value
        }.toMap().let(primaryConstructor::callBy)
    }
}