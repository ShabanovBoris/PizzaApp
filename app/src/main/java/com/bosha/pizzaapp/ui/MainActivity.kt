package com.bosha.pizzaapp.ui

import androidx.appcompat.app.AppCompatActivity
import com.bosha.pizzaapp.R
import com.bosha.pizzaapp.ui.di.Screen
import com.bosha.pizzaapp.ui.di.ScreenComponent
import com.bosha.pizzaapp.utils.createScreenComponent

class MainActivity : AppCompatActivity(R.layout.activity_main), Screen {

    override val screenComponent: ScreenComponent by lazy {
        createScreenComponent()
    }


}
