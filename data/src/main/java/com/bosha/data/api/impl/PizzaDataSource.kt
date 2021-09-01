package com.bosha.data.api.impl

import com.bosha.data.api.PizzaApi
import com.bosha.data.mappers.PizzaApiResponseMapper
import com.bosha.domain.entities.PizzaItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PizzaDataSource @Inject constructor(
    private val api: PizzaApi,
    private val mapper: PizzaApiResponseMapper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main.immediate
) {
    fun getPizzaList(): Flow<List<PizzaItem>> =
        flow { emit(api.getPizzaList()) }
            .map { list ->
                mapper {
                    list.mapToPizzaItemList()
                }
            }
            .flowOn(dispatcher)


    suspend fun putPizza(pizzaItem: PizzaItem) = withContext(dispatcher) {
        api.putPizza(
            mapper {
                pizzaItem.mapToPizzaApiResponse()
            }
        )
    }

}