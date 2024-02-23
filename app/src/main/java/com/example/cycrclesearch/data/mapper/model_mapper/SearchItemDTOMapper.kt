package com.example.cycrclesearch.data.mapper.model_mapper

import com.example.cycrclesearch.data.model.ChildrenDTO
import com.example.cycrclesearch.data.model.ChildrenXDTO
import com.example.cycrclesearch.data.model.ChildrenXXDTO
import com.example.cycrclesearch.data.model.ChildrenXXXDTO
import com.example.cycrclesearch.data.model.ChildrenXXXXDTO
import com.example.cycrclesearch.data.model.SearchItemDTO
import com.example.cycrclesearch.domain.model.GetChildren
import com.example.cycrclesearch.domain.model.GetChildrenX
import com.example.cycrclesearch.domain.model.GetChildrenXX
import com.example.cycrclesearch.domain.model.GetChildrenXXX
import com.example.cycrclesearch.domain.model.GetChildrenXXXX
import com.example.cycrclesearch.domain.model.GetSearchItem


fun SearchItemDTO.toDomain() =
    GetSearchItem(
        id = id,
        children = children.map { it.toDomain() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun ChildrenDTO.toDomain() =
    GetChildren(
        id = id,
        children = children.map { it.toDomain() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun ChildrenXDTO.toDomain() =
    GetChildrenX(
        id = id,
        children = children.map { it.toDomain() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun ChildrenXXDTO.toDomain() =
    GetChildrenXX(
        id = id,
        children = children.map { it.toDomain() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun ChildrenXXXDTO.toDomain() =
    GetChildrenXXX(
        id = id,
        children = children.map { it.toDomain() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun ChildrenXXXXDTO.toDomain() =
    GetChildrenXXXX(
        id = id,
        children = children,
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )
