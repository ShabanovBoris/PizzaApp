package com.bosha.pizzaapp.ui.pizza

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bosha.domain.common.SuccessResult
import com.bosha.domain.entities.PizzaItem
import com.bosha.domain.usecases.DeletePizzaUseCase
import com.bosha.domain.usecases.GetPizzaListUseCase
import com.bosha.domain.usecases.PutPizzaUseCase
import com.bosha.pizzaapp.databinding.CurrentWeatherFragmentBinding
import com.bosha.pizzaapp.utils.injectDeps
import com.bosha.pizzaapp.utils.viewModelCreator
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


class Fragment : Fragment() {


    @Inject lateinit var useCase1: GetPizzaListUseCase
    @Inject lateinit var useCase2: DeletePizzaUseCase
    @Inject lateinit var useCase3: PutPizzaUseCase
    private val viewModel by viewModelCreator<ViewModel> {
        ViewModel(useCase1, useCase2, useCase3)
    }

    /**
     * Called when a fragment is first attached to its context.
     * [.onCreate] will be called after this.
     */
    override fun onAttach(context: Context) {
        injectDeps()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return CurrentWeatherFragmentBinding.inflate(inflater, container, false).run {


            return@run root
        }
    }

}