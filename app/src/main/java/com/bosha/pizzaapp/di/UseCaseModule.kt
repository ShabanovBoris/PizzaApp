package com.bosha.pizzaapp.di

import com.bosha.domain.repositories.PizzaRepository
import com.bosha.domain.usecases.GetCachePizzaUseCase
import com.bosha.domain.usecases.GetPizzaListUseCase
import com.bosha.domain.usecases.PutCachePizzaUseCase
import com.bosha.domain.usecases.PutPizzaUseCase
import com.bosha.pizzaapp.di.scopes.ScreenScope
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @ScreenScope
    @Provides
    fun provideGetPizzaListUseCase(repository: PizzaRepository): GetPizzaListUseCase =
        GetPizzaListUseCase(repository)

    @ScreenScope
    @Provides
    fun providePutPizzaUseCase(repository: PizzaRepository):  PutPizzaUseCase =
        PutPizzaUseCase(repository)

    @ScreenScope
    @Provides
    fun providePutCachePizzaUseCase(repository: PizzaRepository):  PutCachePizzaUseCase =
        PutCachePizzaUseCase(repository)

    @ScreenScope
    @Provides
    fun provideGetCachePizzaUseCase(repository: PizzaRepository):  GetCachePizzaUseCase =
        GetCachePizzaUseCase(repository)

}