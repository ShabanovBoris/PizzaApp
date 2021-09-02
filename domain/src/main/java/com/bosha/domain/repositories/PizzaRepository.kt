package com.bosha.domain.repositories

import com.bosha.domain.common.Result
import com.bosha.domain.entities.PizzaItem
import kotlinx.coroutines.flow.Flow

interface PizzaRepository {
    fun getPizzaList(): Flow<Result<List<PizzaItem>>>

    suspend fun putPizza(pizzaItem: PizzaItem)

    suspend fun getCachePizza(): Flow<List<PizzaItem>>

    suspend fun putCachePizza(list: List<PizzaItem>)
}