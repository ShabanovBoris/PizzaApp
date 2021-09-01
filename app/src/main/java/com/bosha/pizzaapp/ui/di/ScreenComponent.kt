package com.bosha.pizzaapp.ui.di

import com.bosha.pizzaapp.ui.MainActivity
import com.bosha.pizzaapp.di.DataModule
import com.bosha.pizzaapp.di.UseCaseModule
import com.bosha.pizzaapp.di.PizzaApiModule
import com.bosha.pizzaapp.di.scopes.ScreenScope
import com.bosha.pizzaapp.ui.mainscreen.MainFragment
import dagger.Subcomponent

@ScreenScope
@Subcomponent(modules = [PizzaApiModule::class, UseCaseModule::class, DataModule::class])
interface ScreenComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ScreenComponent
    }

    fun inject(mainFragment: MainFragment)
    fun inject(activity: MainActivity)
}