package com.bosha.pizzaapp.ui.mainscreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.bosha.domain.common.SuccessResult
import com.bosha.domain.entities.PizzaItem
import com.bosha.domain.usecases.GetPizzaListUseCase
import com.bosha.domain.usecases.PutPizzaUseCase
import com.bosha.pizzaapp.R
import com.bosha.pizzaapp.databinding.FragmentMainBinding
import com.bosha.pizzaapp.utils.injectDeps
import com.bosha.pizzaapp.utils.viewModelCreator
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject


class MainFragment : Fragment() {


    @Inject
    lateinit var useCase1: GetPizzaListUseCase

    @Inject
    lateinit var useCase3: PutPizzaUseCase
    private val viewModel by viewModelCreator<ViewModel> {
        ViewModel(useCase1, useCase3)
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
        return FragmentMainBinding.inflate(inflater, container, false).run {

            /**
             * Hardcode the banner's images
             */
            rvBanners.adapter = BannersAdapter().also {
                it.bannersResIds = listOf(
                    ContextCompat.getDrawable(requireContext(), R.drawable.banner1),
                    ContextCompat.getDrawable(requireContext(), R.drawable.banner2),
                )
            }

            rvMainList.adapter = PizzaMainListAdapter().apply {
                setOnEditListener { /*****/ }
                lifecycleScope.launchWhenCreated {
                    viewModel.getPizzas().collect {
                        try {
                            submitList((it as SuccessResult<List<PizzaItem>>).data)
                        }catch (e: Exception)
                        {
                            Log.e("TAG", "onCreateView: ERRRRRRRRROR", )
                        }

                    }
                }
            }
            rvMainList.apply {
                setHasFixedSize(true)
                addItemDecoration(
                    DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                    )
                )
            }



            return@run root
        }
    }

}