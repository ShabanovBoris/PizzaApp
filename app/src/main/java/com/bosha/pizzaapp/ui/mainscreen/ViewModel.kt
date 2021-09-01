package com.bosha.pizzaapp.ui.mainscreen

import androidx.lifecycle.ViewModel
import com.bosha.domain.entities.PizzaItem
import com.bosha.domain.usecases.GetPizzaListUseCase
import com.bosha.domain.usecases.PutPizzaUseCase

//54.1836563 37.6426194
class ViewModel(
    private val getPizzaListUseCase: GetPizzaListUseCase,
    private val putPizzaUseCase: PutPizzaUseCase,
) : ViewModel() {

//    private val handler = CoroutineExceptionHandler(::logError)

//    private val _actionStateFlow: MutableStateFlow<Weather> =
//        MutableStateFlow(ActionState.EMPTY)
//    val actionStateFlow get() = _actionStateFlow.asStateFlow()

    fun getPizzas() = getPizzaListUseCase()

    suspend fun putPizza(pizzaItem: PizzaItem) = putPizzaUseCase(pizzaItem)

}