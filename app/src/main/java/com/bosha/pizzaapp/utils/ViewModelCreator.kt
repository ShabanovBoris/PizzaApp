package com.bosha.pizzaapp.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//todo make interface usecase
typealias ViewModelCreator = () -> ViewModel?

class ViewModelFactory (
    private val creator: ViewModelCreator
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return creator() as T
    }
}

/**
 * Create view-model directly by calling its constructor.
 */
inline fun <reified VM : ViewModel> Fragment.viewModelCreator(
    noinline creator: ViewModelCreator
): Lazy<VM> {
    return viewModels { ViewModelFactory(creator) }
}