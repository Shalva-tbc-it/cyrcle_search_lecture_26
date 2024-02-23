package com.example.cycrclesearch.presentation.model

data class Children(
    val id: String,
    val bglNumber: String? = null,
    val bglVariant: String? = null,
    val children: List<ChildrenX>,
    val createdAt: String,
    val main: String? = null,
    val name: String,
    val nameDe: String,
    val orderId: Int?
)
