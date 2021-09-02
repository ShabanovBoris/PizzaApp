package com.bosha.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bosha.data.dto.PizzaCacheEntity

@Database(entities = [PizzaCacheEntity::class], version = 1)
abstract class PizzaDataBase: RoomDatabase() {

    abstract fun pizzaDao(): PizzaDao
}