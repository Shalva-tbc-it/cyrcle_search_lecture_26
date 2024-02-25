package com.example.cycrclesearch.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cycrclesearch.data.common.Resource
import com.example.cycrclesearch.domain.usecase.GetSearchItemUseCase
import com.example.cycrclesearch.presentation.event.HomeEvent
import com.example.cycrclesearch.presentation.mapper.toPresentation
import com.example.cycrclesearch.presentation.model.SearchItem
import com.example.cycrclesearch.presentation.state.SearchItemState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchItemUseCase: GetSearchItemUseCase
): ViewModel() {

    private val _searchItemState = MutableStateFlow(SearchItemState<SearchItem>())
    val searchItemState: SharedFlow<SearchItemState<SearchItem>> = _searchItemState.asStateFlow()

    private val _inputText = MutableStateFlow<String>("")
    val inputText: StateFlow<String> = _inputText

    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.GetSearchItem -> setInputText(event.title)
            is HomeEvent.ResetErrorMessage -> updateErrorMessage(message = null)
        }
    }

    private fun setInputText(text: String) {
        _inputText.value = text
    }

    init {
        observeInputText()
    }

    private fun observeInputText() {
        _inputText
            .debounce(1500)
            .onEach { text ->
                if (_inputText.value == text) {
                    getSearchItem(text)
                }
            }
            .launchIn(viewModelScope)
    }

    private fun getSearchItem(title: String) {
        viewModelScope.launch {
            searchItemUseCase.invoke(title = title).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _searchItemState.update { state ->
                            state.copy(loading = resource.loading)
                        }
                    }
                    is Resource.Success -> {
                        _searchItemState.update { state ->
                            state.copy(data = resource.data.map { it.toPresentation() })
                        }
                    }
                    is Resource.Error -> {
                        updateErrorMessage(message = resource.errorMessage)
                    }
                }
            }
        }
    }

    private fun updateErrorMessage(message: String?) {
        _searchItemState.update { it.copy(errorMessage = message) }
    }

}