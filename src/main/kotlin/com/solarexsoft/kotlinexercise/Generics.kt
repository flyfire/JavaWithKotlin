package com.solarexsoft.kotlinexercise

abstract class PracticeQuestion

class AQuestion : PracticeQuestion()

class BQuestion : PracticeQuestion()

interface IQuestionView<T: PracticeQuestion> {
    fun bindData(data: T)
}

class AQuestionView : IQuestionView<AQuestion> {
    override fun bindData(data: AQuestion) {

    }

}

fun main() {
    AQuestionView::class.supertypes.first().arguments.forEach {
        println(it.type)
    }
}



interface GenericSuper<T : GenericSuper<T>> {
    fun h(t: T): T
}


interface XXXX<out T : YYYY<XXXX<T>>>

interface YYYY<out T : XXXX<YYYY<T>>>




interface ZZZZ<T: PracticeQuestion, U: IQuestionView<T>>

interface H1<T : H1<T>> : GenericSuper<T> {

}

interface Aa : GenericSuper<Aa>
interface A1 : GenericSuper<H2>

interface H2 : GenericSuper<H2> {

}

interface H3 : H2

enum class AAA {
    aaa;
}


