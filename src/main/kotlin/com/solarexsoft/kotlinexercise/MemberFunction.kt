package com.solarexsoft.kotlinexercise


/*
 * Created by Solarex on 2022/12/19 17:17
 */
interface IUiState
open class BaseViewModel<UiState : IUiState> {
    lateinit var state: UiState
    // hi 会被编译为Function1 invoke接收一个UiState类型的参数
    fun update(hi: UiState.() -> UiState) {
        hi(state)
    }
}