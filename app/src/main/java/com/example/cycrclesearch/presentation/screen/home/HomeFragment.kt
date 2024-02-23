
package com.example.cycrclesearch.presentation.screen.home

import android.util.Log.d
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cycrclesearch.databinding.FragmentHomeBinding
import com.example.cycrclesearch.presentation.common.base.BaseFragment
import com.example.cycrclesearch.presentation.event.HomeEvent
import com.example.cycrclesearch.presentation.extension.showSnackBar
import com.example.cycrclesearch.presentation.model.SearchItem
import com.example.cycrclesearch.presentation.state.SearchItemState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()

    override fun bind() {
        viewModel.onEvent(HomeEvent.GetSearchItem)
    }

    override fun bindViewActionListener() {

    }

    override fun bindObserves() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.searchItemState.collect {
                    handleSearchItem(it)
                }
            }
        }
    }


    private fun handleSearchItem(state: SearchItemState<SearchItem>) {
        binding.progressBar.visibility =
            if (state.loading) View.VISIBLE else View.GONE

        state.data?.let {
            d("getData", "${it.size}")
        }

        state.errorMessage?.let {
            binding.root.showSnackBar(message = it)
            d("getData", it)
            HomeEvent.ResetErrorMessage
        }

    }

}