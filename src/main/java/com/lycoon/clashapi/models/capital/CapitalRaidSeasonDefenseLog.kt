package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class CapitalRaidSeasonDefenseLog
(
    val defender: CapitalRaidSeasonClanInfo,
    val attackCount: Int = 0,
    val districtCount: Int = 0,
    val districtsDestroyed: Int = 0,
    val districts: List<CapitalRaidSeasonDistrict>
)