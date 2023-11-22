package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class CapitalDistrict
(
    val name: String? = null,
    val id: Int = 0,
    val districtHallLevel: Int = 0,
)