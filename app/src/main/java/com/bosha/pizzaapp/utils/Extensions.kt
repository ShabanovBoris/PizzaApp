package com.bosha.pizzaapp.utils

import com.bosha.pizzaapp.ui.MainActivity
import com.bosha.pizzaapp.PizzaApp
import com.bosha.pizzaapp.ui.di.Screen
import com.bosha.pizzaapp.ui.mainscreen.MainFragment

fun MainFragment.injectDeps() =
    (requireActivity() as Screen).screenComponent.inject(this@injectDeps)

fun MainActivity.createScreenComponent() =
    (application as PizzaApp).appComponent.plusMainScreenComponent().create()
        .apply{
            inject(this@createScreenComponent)
        }