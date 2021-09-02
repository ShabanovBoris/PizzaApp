package com.bosha.pizzaapp.ui.mainscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bosha.domain.common.ErrorResult
import com.bosha.domain.common.PendingResult
import com.bosha.domain.common.Result
import com.bosha.domain.common.SuccessResult
import com.bosha.domain.entities.PizzaItem
import com.bosha.domain.usecases.GetCachePizzaUseCase
import com.bosha.domain.usecases.GetPizzaListUseCase
import com.bosha.domain.usecases.PutCachePizzaUseCase
import com.bosha.domain.usecases.PutPizzaUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val getPizzaListUseCase: GetPizzaListUseCase,
    private val putPizzaUseCase: PutPizzaUseCase,
    private val putCachePizzaUseCase: PutCachePizzaUseCase,
    private val getCachePizzaUseCase: GetCachePizzaUseCase,
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, throwable ->
        Log.e(
            this::class.java.simpleName,
            throwable.toString()
        )
    }

    init {
        viewModelScope.launch(handler) {
            getPizzaListUseCase().collect {
                when(it){
                    is ErrorResult -> {
                        _sideEffect.value = SideEffectActions.ERROR
                    }
                    is PendingResult -> {
                        _sideEffect.value = SideEffectActions.LOADING
                    }
                    is SuccessResult -> {
                        _pizzaResultFlow.value = it.data
                        _sideEffect.value = SideEffectActions.SUCCESS
                        putCachePizzaUseCase(it.data)
                    }
                }
            }
        }
    }

    private val _pizzaResultFlow: MutableStateFlow<List<PizzaItem>> =
        MutableStateFlow(emptyList())
    val actionStateFlow get() = _pizzaResultFlow.asStateFlow()

    private val _sideEffect: MutableStateFlow<SideEffectActions> =
        MutableStateFlow(SideEffectActions.LOADING)
    val sideEffect get() = _sideEffect.asStateFlow()


    /**
     * used for fill backend in
     */
    suspend fun putPizza(pizzaItem: PizzaItem) = putPizzaUseCase(pizzaItem)

    enum class SideEffectActions{
        LOADING,
        ERROR,
        SUCCESS
    }
}