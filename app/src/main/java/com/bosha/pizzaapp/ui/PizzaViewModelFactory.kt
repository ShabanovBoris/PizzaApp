package com.bosha.pizzaapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bosha.domain.usecases.GetCachePizzaUseCase
import com.bosha.domain.usecases.GetPizzaListUseCase
import com.bosha.domain.usecases.PutCachePizzaUseCase
import com.bosha.domain.usecases.PutPizzaUseCase
import com.bosha.pizzaapp.di.scopes.ScreenScope
import com.bosha.pizzaapp.ui.mainscreen.MainViewModel
import javax.inject.Inject

@ScreenScope
class PizzaViewModelFactory @Inject constructor(
    private val getPizzaListUseCase: GetPizzaListUseCase,
    private val putPizzaUseCase: PutPizzaUseCase,
    private val putCachePizzaUseCase: PutCachePizzaUseCase,
    private val getCachePizzaUseCase: GetCachePizzaUseCase
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {

        MainViewModel::class.java -> MainViewModel(
            getPizzaListUseCase,
            putPizzaUseCase,
            putCachePizzaUseCase,
            getCachePizzaUseCase
        )

        else -> error("$modelClass is not registered ViewModel")
    } as T
}
