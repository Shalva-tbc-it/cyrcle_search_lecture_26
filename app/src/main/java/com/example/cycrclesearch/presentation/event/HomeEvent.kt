package com.example.cycrclesearch.presentation.event

sealed class HomeEvent {

    data object GetSearchItem: HomeEvent()
    data object ResetErrorMessage : HomeEvent()

}