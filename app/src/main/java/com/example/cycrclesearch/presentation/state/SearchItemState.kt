package com.example.cycrclesearch.presentation.state

data class SearchItemState<SearchItem>(
    val loading: Boolean = false,
    val data: List<SearchItem>? = null,
    val errorMessage: String? = null
)
