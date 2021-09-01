package com.bosha.data.repositoriesImpl

import com.bosha.data.api.impl.PizzaDataSource
import com.bosha.domain.common.ErrorResult
import com.bosha.domain.common.Result
import com.bosha.domain.common.SuccessResult
import com.bosha.domain.entities.PizzaItem
import com.bosha.domain.repositories.PizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.inject.Inject

class PizzaRepositoryImpl @Inject constructor(
    private val dataSource: PizzaDataSource
) : PizzaRepository {
    override fun getPizzaList(): Flow<Result<List<PizzaItem>>> {
        return dataSource.getPizzaList()
            .map { SuccessResult(it) as Result<List<PizzaItem>> }
            .catch { cause ->
                if ((cause is retrofit2.HttpException) ||
                    (cause is TimeoutException) ||
                    (cause is UnknownHostException)
                )
                    emit(ErrorResult(cause as Exception))

                else throw cause
            }
    }

    override suspend fun putPizza(pizzaItem: PizzaItem) {
        dataSource.putPizza(pizzaItem)
    }
}