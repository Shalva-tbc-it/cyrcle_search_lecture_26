package com.example.cycrclesearch.data.mapper.model_mapper

import com.example.cycrclesearch.data.model.SearchItemDTO
import com.example.cycrclesearch.domain.model.GetSearchItem


fun SearchItemDTO.toDomain() : GetSearchItem =
    GetSearchItem(
        id = id,
        children = children?.filterNot { it.id == id }?.map { it.toDomain() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )
