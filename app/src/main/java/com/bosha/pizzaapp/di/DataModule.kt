package com.bosha.pizzaapp.di

import com.bosha.data.repositoriesImpl.PizzaRepositoryImpl
import com.bosha.domain.repositories.PizzaRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun provideWeatherRepository(repositoryImpl: PizzaRepositoryImpl): PizzaRepository
}