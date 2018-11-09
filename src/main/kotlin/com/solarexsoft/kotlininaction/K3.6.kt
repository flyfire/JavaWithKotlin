package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
class User(val id: Int, val name: String, val address: String)
// 局部函数
fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty filename: $fieldName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
}