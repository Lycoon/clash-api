package com.lycoon.clashapi.models.capital

import kotlinx.serialization.Serializable

@Serializable
data class CapitalRanking (
    val clanPoints: Int = 0,
    val clanCapitalPoints: Int = 0
)