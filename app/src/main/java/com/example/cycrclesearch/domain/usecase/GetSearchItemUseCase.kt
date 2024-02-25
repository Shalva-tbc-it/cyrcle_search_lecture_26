package com.example.cycrclesearch.domain.usecase

import com.example.cycrclesearch.data.common.Resource
import com.example.cycrclesearch.domain.model.GetSearchItem
import com.example.cycrclesearch.domain.repository.SearchItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetSearchItemUseCase @Inject constructor(
    private val searchItemRepository: SearchItemRepository
) {

    suspend operator fun invoke(title: String): Flow<Resource<List<GetSearchItem>>> {
        if (title.isNullOrBlank()) {
            return flow {
                emit(Resource.Success(emptyList()))
            }
        }

        return searchItemRepository.getSearchItem(title = title).map { resource ->
            if (resource is Resource.Success) {
                val filteredList = resource.data.filter { it.name?.contains(title, ignoreCase = true) == true }
                if (filteredList.isNotEmpty()) {
                    Resource.Success(filteredList)
                } else {
                    Resource.Error("No items found for the given title")
                }
            } else {
                resource
            }
        }
    }
}