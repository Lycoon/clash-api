package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class CapitalRaidSeasonDistrict
(
    val id: Int = 0,
    val name: String? = null,
    val stars: Int = 0,
    val destructionPercent: Float = 0f,
    val attackCount: Int = 0,
    val totalLooted: Int = 0,
    val attacks: List<CapitalRaidSeasonAttack>,
    val districtHallLevel: Int = 0
)