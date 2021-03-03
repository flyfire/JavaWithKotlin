package com.solarexsoft.kotlinexercise

/**
 * Created by Solarex at 9:48 PM/2/28/21
 * Desc:
 */
open class Waste
class DryWaste: Waste()
class Dustbin<in T: Waste> {
    fun put(t: T){
    }
}

fun contravariant() {
    val dustbin: Dustbin<Waste> = Dustbin<Waste>()
    val dryWasteDustbin: Dustbin<DryWaste> = Dustbin<DryWaste>()

    val waste = Waste()
    val dryWaste = DryWaste()

    dustbin.put(waste)
    dustbin.put(dryWaste)

//    dryWasteDustbin.put(waste)
    dryWasteDustbin.put(dryWaste)
}