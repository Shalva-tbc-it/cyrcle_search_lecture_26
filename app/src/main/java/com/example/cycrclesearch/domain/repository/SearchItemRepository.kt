package com.example.cycrclesearch.domain.repository

import com.example.cycrclesearch.data.common.Resource
import com.example.cycrclesearch.domain.model.GetSearchItem
import kotlinx.coroutines.flow.Flow

interface SearchItemRepository {

    suspend fun getSearchItem(): Flow<Resource<List<GetSearchItem>>>

}