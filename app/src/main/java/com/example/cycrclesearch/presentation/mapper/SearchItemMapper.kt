package com.example.cycrclesearch.presentation.mapper

import com.example.cycrclesearch.domain.model.GetChildren
import com.example.cycrclesearch.domain.model.GetChildrenX
import com.example.cycrclesearch.domain.model.GetChildrenXX
import com.example.cycrclesearch.domain.model.GetChildrenXXX
import com.example.cycrclesearch.domain.model.GetChildrenXXXX
import com.example.cycrclesearch.domain.model.GetSearchItem
import com.example.cycrclesearch.presentation.model.Children
import com.example.cycrclesearch.presentation.model.ChildrenX
import com.example.cycrclesearch.presentation.model.ChildrenXX
import com.example.cycrclesearch.presentation.model.ChildrenXXX
import com.example.cycrclesearch.presentation.model.ChildrenXXXX
import com.example.cycrclesearch.presentation.model.SearchItem

fun GetSearchItem.toPresentation() =
    SearchItem(
        id = id,
        children = children.map { it.toPresentation() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun GetChildren.toPresentation() =
    Children(
        id = id,
        children = children.map { it.toPresentation() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun GetChildrenX.toPresentation() =
    ChildrenX(
        id = id,
        children = children.map { it.toPresentation() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun GetChildrenXX.toPresentation() =
    ChildrenXX(
        id = id,
        children = children.map { it.toPresentation() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun GetChildrenXXX.toPresentation() =
    ChildrenXXX(
        id = id,
        children = children.map { it.toPresentation() },
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )

fun GetChildrenXXXX.toPresentation() =
    ChildrenXXXX(
        id = id,
        children = children,
        createdAt = createdAt,
        name = name,
        nameDe = nameDe,
        orderId = orderId

    )