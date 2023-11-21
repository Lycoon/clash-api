package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class ClanCapital
(
    val capitalHallLevel: Int = 0,
    val districts: List<CapitalDistrict>,
)