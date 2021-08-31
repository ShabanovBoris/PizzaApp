package com.bosha.pizzaapp.di

import com.bosha.domain.repositories.PizzaRepository
import com.bosha.domain.usecases.DeletePizzaUseCase
import com.bosha.domain.usecases.GetPizzaListUseCase
import com.bosha.domain.usecases.PutPizzaUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class UseCaseModule {

    @Provides
    fun provideGetPizzaListUseCase(repository: PizzaRepository): GetPizzaListUseCase =
        GetPizzaListUseCase(repository)

    @Provides
    fun provideDeletePizzaUseCase(repository: PizzaRepository): DeletePizzaUseCase =
        DeletePizzaUseCase(repository)

    @Provides
    fun providePutPizzaUseCase(repository: PizzaRepository):  PutPizzaUseCase =
        PutPizzaUseCase(repository)



    //todo stub
    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.Main

}