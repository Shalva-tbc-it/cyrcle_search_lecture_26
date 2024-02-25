package com.example.cycrclesearch.data.service

import com.example.cycrclesearch.data.model.SearchItemDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchItemService {

    @GET("6f722f19-3297-4edd-a249-fe765e8104db/{title}")
    suspend fun getSearchItem(@Path("title") title: String) : Response<List<SearchItemDTO>>

}