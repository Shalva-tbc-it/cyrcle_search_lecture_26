package com.example.cycrclesearch.di

import com.example.cycrclesearch.data.common.HandleResponse
import com.example.cycrclesearch.data.repository.SearchItemRepositoryImpl
import com.example.cycrclesearch.data.service.SearchItemService
import com.example.cycrclesearch.domain.repository.SearchItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideSearchItemRepository(
        handleResponse: HandleResponse,
        searchItemService: SearchItemService
    ): SearchItemRepository {
        return SearchItemRepositoryImpl(
            handleResponse = handleResponse,
            searchItemService = searchItemService
        )
    }

}