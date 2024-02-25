
package com.example.cycrclesearch.presentation.screen.home

import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cycrclesearch.databinding.FragmentHomeBinding
import com.example.cycrclesearch.presentation.common.base.BaseFragment
import com.example.cycrclesearch.presentation.event.HomeEvent
import com.example.cycrclesearch.presentation.extension.showSnackBar
import com.example.cycrclesearch.presentation.model.SearchItem
import com.example.cycrclesearch.presentation.screen.home.adapter.SearchItemRecyclerAdapter
import com.example.cycrclesearch.presentation.state.SearchItemState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter: SearchItemRecyclerAdapter

    override fun bind() {
        bindAdapter()
    }

    override fun bindViewActionListener() {
        binding.edTitle.doAfterTextChanged {
            viewModel.onEvent(HomeEvent.GetSearchItem(it.toString()))
        }
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

    private fun bindAdapter() {
        adapter = SearchItemRecyclerAdapter()
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = adapter
    }


    private fun handleSearchItem(state: SearchItemState<SearchItem>) {
        binding.progressBar.visibility =
            if (state.loading) View.VISIBLE else View.GONE

        state.data?.let {
            adapter.submitList(it)
        }

        state.errorMessage?.let {
            binding.root.showSnackBar(message = it)
            HomeEvent.ResetErrorMessage
        }

    }

}