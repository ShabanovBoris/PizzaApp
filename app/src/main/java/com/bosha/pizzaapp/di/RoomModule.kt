package com.bosha.pizzaapp.di

import android.content.Context
import androidx.room.Room
import com.bosha.data.db.DbContract
import com.bosha.data.db.PizzaDao
import com.bosha.data.db.PizzaDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providePizzaDataBase(appContext: Context): PizzaDataBase =
        Room.databaseBuilder(
            appContext,
            PizzaDataBase::class.java,
            DbContract.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun providePizzaDao(pizzaDataBase: PizzaDataBase): PizzaDao =
        pizzaDataBase.pizzaDao()
}