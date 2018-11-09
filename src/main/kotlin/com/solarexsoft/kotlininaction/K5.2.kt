package com.solarexsoft.kotlininaction

/**
 * Created by houruhou on 2018/10/25.
 * Desc:
 */
data class KPerson(val name: String, val age: Int)


fun main(args: Array<String>) {
    val list = listOf<Int>(1, 2, 3, 4)
    var filter = list.filter { it % 2 == 0 }
    println(filter.javaClass)
    println(filter)
    val filterF = Iterable<String>::filter
//    filter = Iterable<String>::filter
    println(filterF.javaClass)
    val people = listOf<KPerson>(KPerson("Alice", 29), KPerson("Bob", 35))
    val peopleF = people.filter { it.age > 30 }
    println(peopleF.javaClass)
    println(peopleF)
    val listM = list.map { it * it }
    println(listM.javaClass)
    println(listM)
    val peopleM = people.map { it.name }
    println(peopleM.javaClass)
    println(peopleM)
    println(people.map(KPerson::age))
    println(people.filter { it.age > 30 }.map { it.name })
    println(people.filter { it.age == people.maxBy(KPerson::age)?.age }.map { it.name })
    val maxAge = people.maxBy { it.age }?.age
    println(people.filter { it.age == maxAge }.map { it.name })

    val numbers = mapOf<Int, String>(1.to("one"), 2 to "two")
    val numbersM = numbers.mapValues { it.value.toUpperCase() }
    val numbersK = numbers.mapKeys { StringBuilder("Solarex").append(it.key).toString() }
    println(numbersM.javaClass)
    println(numbersM)
    println(numbers)
    println(numbersK)
    println("---------------")
    val canBeInClub27 = { p: KPerson -> p.age <= 27 }
    val kpeople = listOf<KPerson>(KPerson("Alice", 27), KPerson("Bob", 31), KPerson("Sam", 21), KPerson("Justin", 21))
    println(kpeople.all(canBeInClub27))
    println(kpeople.any(canBeInClub27))
    println(kpeople.find(canBeInClub27))
    println(kpeople.count(canBeInClub27))

    println(kpeople.groupBy { it.age })

    val l = listOf<String>("a", "b", "ab", "bc", "cc", "cd")
    println(l.groupBy(String::first))

    class Book(val title: String,val authors: List<String>)

    val strings = listOf("abc", "cde", "def", "defgh")
    println(strings.flatMap { it.toList() })

    val books = listOf(Book("Link", listOf("Solarex")), Book("Web", listOf("Solarex", "flyfire")), Book("Java", listOf("flyfire")))
    println(books.flatMap { it.authors }.toSet())
    var listOfLists = listOf(
            listOf(1),
            listOf(1,2,3),
            listOf(3,4,5)
    )
    println(listOfLists.flatten())

}