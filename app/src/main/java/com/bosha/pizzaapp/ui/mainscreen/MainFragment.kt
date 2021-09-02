package com.bosha.pizzaapp.ui.mainscreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.bosha.domain.common.SuccessResult
import com.bosha.domain.entities.PizzaItem
import com.bosha.pizzaapp.R
import com.bosha.pizzaapp.databinding.FragmentMainBinding
import com.bosha.pizzaapp.ui.PizzaViewModelFactory
import com.bosha.pizzaapp.utils.injectDeps
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = checkNotNull(_binding)

    @Inject
    lateinit var viewModelFactory: PizzaViewModelFactory

    private val viewModel: MainViewModel by viewModels{ viewModelFactory }

    override fun onAttach(context: Context) {
        injectDeps()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         _binding = FragmentMainBinding.inflate(inflater, container, false).apply{
            setUpBanners(this)
            setUpMainRecycler(this)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.actionStateFlow
                .onEach(::handleResult)
                .launchIn(viewLifecycleOwner.lifecycleScope)

            viewModel.sideEffect
                .onEach(::handleSideEffect)
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private fun setUpBanners(binding: FragmentMainBinding) {
        /**
         * Hardcode the banner's images
         */
        binding.rvBanners.adapter = BannersAdapter().also {
            it.bannersResIds = listOf(
                ContextCompat.getDrawable(requireContext(), R.drawable.banner1),
                ContextCompat.getDrawable(requireContext(), R.drawable.banner2),
            )
        }
    }

    private fun setUpMainRecycler(binding: FragmentMainBinding) {
        binding.rvMainList.apply {
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }
        binding.rvMainList.adapter = PizzaMainListAdapter().apply {
            setOnClickListener {
                /**
                 * @stub toast
                 */
                Toast.makeText(
                    requireContext(),
                    "Navigate to details ${it.title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun handleResult(list: List<PizzaItem>){
        (binding.rvMainList.adapter as PizzaMainListAdapter).submitList(list)
    }
    private fun handleSideEffect(effect: MainViewModel.SideEffectActions){
        when(effect){
            MainViewModel.SideEffectActions.LOADING -> {
                binding.pbLoading.visibility = View.VISIBLE
            }
            MainViewModel.SideEffectActions.ERROR -> {
                Toast.makeText(requireContext(), "Error loading data", Toast.LENGTH_SHORT).show()
            }
            MainViewModel.SideEffectActions.SUCCESS -> {
                binding.pbLoading.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}