package com.example.mvpkotlin.presenter

import com.example.mvpkotlin.model.MainModel
import com.example.mvpkotlin.view.MainView

class MainPresenter (private val view : MainView) {
    private val model = MainModel()
    fun calculateResult(number: Int) {
        val result = model.calculateResult(number)
        view.showResult(result)
    }
}