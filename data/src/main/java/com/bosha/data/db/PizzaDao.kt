package com.bosha.data.db


import androidx.room.*
import com.bosha.data.dto.PizzaCacheEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PizzaDao {

    @Query("SELECT * FROM pizza_cache")
    fun getPizzaList(): Flow<List<PizzaCacheEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizzaList(list: List<PizzaCacheEntity>)

    @Query("DELETE FROM pizza_cache")
    suspend fun clear()
}