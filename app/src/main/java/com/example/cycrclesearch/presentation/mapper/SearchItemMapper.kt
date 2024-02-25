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


//
//fun GetChildren.toPresentation() =
//    Children(
//        id = id,
//        children = children.map { it.toPresentation() },
//        createdAt = createdAt,
//        name = name,
//        nameDe = nameDe,
//        orderId = orderId
//
//    )
//
//fun GetChildrenX.toPresentation() =
//    ChildrenX(
//        id = id,
//        children = children.map { it.toPresentation() },
//        createdAt = createdAt,
//        name = name,
//        nameDe = nameDe,
//        orderId = orderId
//
//    )
//
//fun GetChildrenXX.toPresentation() =
//    ChildrenXX(
//        id = id,
//        children = children.map { it.toPresentation() },
//        createdAt = createdAt,
//        name = name,
//        nameDe = nameDe,
//        orderId = orderId
//
//    )
//
//fun GetChildrenXXX.toPresentation() =
//    ChildrenXXX(
//        id = id,
//        children = children.map { it.toPresentation() },
//        createdAt = createdAt,
//        name = name,
//        nameDe = nameDe,
//        orderId = orderId
//
//    )
//
//fun GetChildrenXXXX.toPresentation() =
//    ChildrenXXXX(
//        id = id,
//        children = children,
//        createdAt = createdAt,
//        name = name,
//        nameDe = nameDe,
//        orderId = orderId
//
//    )