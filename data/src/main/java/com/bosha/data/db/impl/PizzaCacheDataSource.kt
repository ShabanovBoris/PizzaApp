package com.bosha.data.db.impl

import android.util.Log
import com.bosha.data.db.PizzaDao
import com.bosha.data.mappers.PizzaCacheMapper
import com.bosha.domain.common.DISPATCHER_MAIN
import com.bosha.domain.entities.PizzaItem
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class PizzaCacheDataSource @Inject constructor(
    private val dao: PizzaDao,
    @param: Named(DISPATCHER_MAIN)
    private val dispatcher: CoroutineDispatcher,
    private val pizzaCacheMapper: PizzaCacheMapper
)  {

     suspend fun getPizzaList(): Flow<List<PizzaItem>> =
        flow { emitAll(dao.getPizzaList()) }
            .catch {
                Log.e(this@PizzaCacheDataSource::class.java.simpleName, "getHabits: error $it")
            }
            .map { list ->
                pizzaCacheMapper {
                    list.mapToPizzaItemList()
                }
            }
            .flowOn(dispatcher)


     suspend fun insertPizzaList(list: List<PizzaItem>) = withContext(dispatcher) {
        dao.insertPizzaList(
            pizzaCacheMapper{
                list.mapToPizzaCacheEntityList()
            }
        )
    }

     suspend fun clear() {
        dao.clear()
    }
}