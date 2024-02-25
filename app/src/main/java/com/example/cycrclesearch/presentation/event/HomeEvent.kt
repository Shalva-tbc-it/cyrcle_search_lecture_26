package com.example.cycrclesearch.presentation.event

sealed class HomeEvent {

    data class GetSearchItem(val title: String) : HomeEvent()
    data object ResetErrorMessage : HomeEvent()

}