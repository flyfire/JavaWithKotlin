package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/24.
 * Desc:
 */
class Client(val name: String, val age: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) {
            return false
        }
        return name == other.name && age == other.age
    }

    override fun toString(): String = "Client(name = $name, age = $age)"

    override fun hashCode(): Int = name.hashCode() * 31 + age
}

data class KClient(val name: String, val age: Int)

class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {}

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        println("add")
        objectsAdded ++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        println("addall")
        objectsAdded+=elements.size
        return innerSet.addAll(elements)
    }
}

fun main(args: Array<String>) {
    val client1 = Client("Solarex", 18)
    val client2 = Client("Solarex", 18)
    println(client1)
    println(client1 == client2)

    val processed = hashSetOf<Client>(Client("Solarex", 18))
    println(processed.contains(Client("Solarex", 18)))

    val cset = CountingSet<Int>()
    cset.add(1)
    cset.addAll(listOf(1, 2, 3))
    println("${cset.objectsAdded} --> ${cset.size}")
    println(cset.innerSet.javaClass)
}