package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/6.
 * Desc:
 */
val sum = {x:Int,y:Int -> x+y}
fun hello(action: (a0:Int, a1:Int, a2:Int, a3:Int, a4:Int, a5:Int, a6:Int, a7:Int,a8:Int,a9:Int,a10:Int,a11:Int,a12:Int,a13:Int,a14:Int,a15:Int,a16:Int,a17:Int,a18:Int,a19:Int,a20:Int,a21:Int) -> Unit) {
    println("Hello")
    action(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21)
}

fun main(args: Array<String>) {
    val a = sum::class
    println(sum::class)
    println(sum.invoke(1,2))
    println(sum(1,3))

    args.forEach(::println)

    println("------------")
    args.forEach label@{
        if (it == "q")
            return@label
        println(it)
    }
    println("------------")
    args.forEach {
        if (it == "q") {
            return@forEach
        }
        println(it)
    }
    println("solarex\n------------")
    println(sum)
    println("------------")
    hello{ i0: Int, i1: Int, i2: Int, i3: Int, i4: Int, i5: Int, i6: Int, i7: Int, i8: Int, i9: Int, i10: Int, i11: Int, i12: Int, i13: Int, i14: Int, i15: Int, i16: Int, i17: Int, i18: Int, i19: Int, i20: Int, i21: Int ->
        println("$i0 $i1 $i2 $i3 $i4 $i5 $i6 $i7 $i8 $i9 $i10 $i11 $i12 $i13 $i14 $i15 $i16 $i17 $i18 $i19 $i20 $i21  ")
    }
    println("------------")
    args.forEach {
        if (it == "q") {
            return
        }
        println(it)
    }
    println("end")
}