package com.bosha.pizzaapp.di

import com.bosha.data.api.PizzaApi
import com.bosha.pizzaapp.di.scopes.ScreenScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PizzaApiModule {

    @ScreenScope
    @Provides
    fun provideHabitApi(retrofit: Retrofit): PizzaApi =
        retrofit.create(PizzaApi::class.java)
}