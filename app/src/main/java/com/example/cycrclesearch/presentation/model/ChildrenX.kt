package com.example.cycrclesearch.presentation.model

data class ChildrenX(
    val id: String,
    val bglNumber: String? = null,
    val bglVariant: String? = null,
    val children: List<ChildrenXX>,
    val createdAt: String,
    val main: String? = null,
    val name: String,
    val nameDe: String,
    val orderId: Int?
)
