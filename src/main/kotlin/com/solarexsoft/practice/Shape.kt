package com.solarexsoft.practice

interface ShapeA<P: Param> {
    fun mianji(param: P)
}

sealed class Param {
    class Radius(val value: Float) : Param()
    class WidthHeight(val width: Float, val height: Float) : Param()
}

class RectA : ShapeA<Param.WidthHeight> {
    override fun mianji(param: Param.WidthHeight) {

    }
}

class CircleA : ShapeA<Param.Radius> {
    override fun mianji(param: Param.Radius) {

    }
}

interface ShapeB {
    fun mianji()
}

class RectB(val width: Float, val height: Float): ShapeB {
    override fun mianji() {

    }
}

class CircleB(val radius: Float) : ShapeB {
    override fun mianji() {

    }
}