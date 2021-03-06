package com.bosha.pizzaapp.di

import android.content.Context
import com.bosha.pizzaapp.ui.di.ScreenComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RetrofitModule::class, Subcomponents::class, DispatcherModule::class, RoomModule::class]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance appContext: Context): AppComponent
    }

    fun plusMainScreenComponent(): ScreenComponent.Factory
}
