package com.example.cycrclesearch.domain.model

data class GetSearchItem(
    val id: String,
    val bglNumber: String? = null,
    val bglVariant: String? = null,
    val children: List<GetSearchItem>?,
    val createdAt: String,
    val main: String? = null,
    val name: String,
    val nameDe: String,
    val orderId: Int?
)
