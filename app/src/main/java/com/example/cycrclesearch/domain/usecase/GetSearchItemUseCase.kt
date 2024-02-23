package com.example.cycrclesearch.domain.usecase

import com.example.cycrclesearch.domain.repository.SearchItemRepository
import javax.inject.Inject

class GetSearchItemUseCase @Inject constructor(
    private val searchItemRepository: SearchItemRepository
) {

    suspend operator fun invoke() = searchItemRepository.getSearchItem()

}