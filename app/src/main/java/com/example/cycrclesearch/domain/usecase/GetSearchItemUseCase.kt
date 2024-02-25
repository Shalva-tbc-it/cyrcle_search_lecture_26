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
                val filteredList = flattenAndFilterList(resource.data, title)
                Resource.Success(filteredList)
            } else {
                resource
            }
        }
    }

    private fun flattenAndFilterList(list: List<GetSearchItem>, title: String): List<GetSearchItem> {
        val flattenedList = mutableListOf<GetSearchItem>()
        for (item in list) {
            if (item.name.startsWith(title, ignoreCase = true)) {
                flattenedList.add(item)
            }
            item.children?.let {
                flattenedList.addAll(flattenAndFilterList(it, title))
            }
        }
        return flattenedList
    }
}
