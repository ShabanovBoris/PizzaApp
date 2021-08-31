package com.bosha.pizzaapp.ui.di

import com.bosha.pizzaapp.ui.MainActivity
import com.bosha.pizzaapp.di.DataModule
import com.bosha.pizzaapp.di.UseCaseModule
import com.bosha.pizzaapp.di.PizzaApiModule
import com.bosha.pizzaapp.di.scopes.ScreenScope
import com.bosha.pizzaapp.ui.pizza.Fragment
import dagger.Subcomponent

@ScreenScope
@Subcomponent(modules = [PizzaApiModule::class, UseCaseModule::class, DataModule::class])
interface ScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ScreenComponent
    }

    fun inject(fragment: Fragment)
    fun inject(activity: MainActivity)
}