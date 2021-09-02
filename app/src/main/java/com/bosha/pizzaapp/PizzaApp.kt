package com.bosha.pizzaapp

import android.app.Application
import com.bosha.pizzaapp.di.AppComponent
import com.bosha.pizzaapp.di.DaggerAppComponent

class PizzaApp: Application() {

    lateinit var appComponent: AppComponent private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}