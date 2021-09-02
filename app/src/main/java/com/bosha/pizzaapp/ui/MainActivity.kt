package com.bosha.pizzaapp.ui

import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bosha.pizzaapp.R
import com.bosha.pizzaapp.ui.di.Screen
import com.bosha.pizzaapp.ui.di.ScreenComponent
import com.bosha.pizzaapp.utils.ConnectivityChecker
import com.bosha.pizzaapp.utils.createScreenComponent
import com.google.android.material.textfield.MaterialAutoCompleteTextView

class MainActivity : AppCompatActivity(R.layout.activity_main), Screen {

    override val screenComponent: ScreenComponent by lazy {
        createScreenComponent()
    }

    override fun onStart() {
        super.onStart()
        ConnectivityChecker.checkConnectionWithToast(this)
        initCityDropdown()
    }

    private fun initCityDropdown() {
        val cityList = listOf(
            "Москва",
            "Санкт-Петербург",
            "Другой город"
        )
        findViewById<MaterialAutoCompleteTextView>(R.id.city_dropdown).apply {
            setAdapter(
                ArrayAdapter(
                    this@MainActivity,
                    R.layout.city_dropdown_item,
                    cityList
                )
            )
            //Moscow by default
            setText(getString(R.string.default_city), false)
        }
    }
}
