package com.example.cycrclesearch.data.repository

import com.example.cycrclesearch.data.common.HandleResponse
import com.example.cycrclesearch.data.common.Resource
import com.example.cycrclesearch.data.mapper.base.asResource
import com.example.cycrclesearch.data.mapper.model_mapper.toDomain
import com.example.cycrclesearch.data.service.SearchItemService
import com.example.cycrclesearch.domain.model.GetSearchItem
import com.example.cycrclesearch.domain.repository.SearchItemRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchItemRepositoryImpl @Inject constructor(
    private val handleResponse: HandleResponse,
    private val searchItemService: SearchItemService
): SearchItemRepository {

    override suspend fun getSearchItem(title: String): Flow<Resource<List<GetSearchItem>>> {
        return handleResponse.safeApiCall {
            searchItemService.getSearchItem(title = title)
        }.asResource { listDTO ->
            listDTO.map {
                it.toDomain()
            }
        }
    }
}