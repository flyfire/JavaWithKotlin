package com.solarexsoft.kotlinexercise

class AndroidView

// 反编译出来是多了一个静态方法，方法有一个AndroidView参数
val AndroidView.isInScreen : Boolean
    get() = false

// 反编译出来是多了两个方法
var AndroidView.justForTest : Boolean
    get() = false
    set(value) {

    }