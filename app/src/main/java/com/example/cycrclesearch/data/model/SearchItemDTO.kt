package com.example.cycrclesearch.data.model

import com.squareup.moshi.Json

data class SearchItemDTO(
    @Json(name = "id")
    val id: String,
    @Json(name = "bgl_number")
    val bglNumber: String? = null,
    @Json(name = "bgl_variant")
    val bglVariant: String? = null,
    @Json(name = "children")
    val children: List<SearchItemDTO>?,
    @Json(name = "createdAt")
    val createdAt: String,
    @Json(name = "main")
    val main: String? = null,
    @Json(name = "name")
    val name: String,
    @Json(name = "name_de")
    val nameDe: String,
    @Json(name = "order_id")
    val orderId: Int?
)