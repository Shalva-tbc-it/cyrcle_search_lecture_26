package com.example.cycrclesearch.presentation.mapper

import com.example.cycrclesearch.domain.model.GetSearchItem
import com.example.cycrclesearch.presentation.model.SearchItem

fun GetSearchItem.toPresentation() : SearchItem =
    SearchItem(
        id = id,
        children = children?.filterNot { it.id == id }?.map { it.toPresentation() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )