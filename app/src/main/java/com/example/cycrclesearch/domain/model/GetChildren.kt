package com.example.cycrclesearch.domain.model

data class GetChildren(
    val id: String,
    val bglNumber: String? = null,
    val bglVariant: String? = null,
    val children: List<GetChildrenX>,
    val createdAt: String,
    val main: String? = null,
    val name: String,
    val nameDe: String,
    val orderId: Int?
)
