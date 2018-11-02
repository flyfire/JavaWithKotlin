package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/26.
 * Desc:
 */
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)
class JobPerson(val name: String, val company: Company?)

fun printShippingLabel(person: JobPerson) {
    val address = person.company?.address ?: throw IllegalArgumentException("No Address")
    with(address) {
        println(streetAddress)
        println("$zipCode $city $country")
    }
}

class TPerson(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? TPerson ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() * 37 + lastName.hashCode()
    }
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(s: String) {
}

fun <T> printHashcode(t: T) {
    println(t?.hashCode())
}

fun <T: Any> printHash(t: T) {
    println(t.hashCode())
}

fun main(args: Array<String>) {
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("jetbrains", address)
    val person = JobPerson("Dmitry", jetbrains)

    printShippingLabel(person)

//    ignoreNulls(null)
    val email: String? = "abc"
    email?.let { sendEmailTo(it) }

    val s: String? = "abc"
    s.isNullOrEmpty()
}