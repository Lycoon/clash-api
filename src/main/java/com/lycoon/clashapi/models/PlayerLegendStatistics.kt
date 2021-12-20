package com.lycoon.clashapi.models

import kotlinx.serialization.Serializable

@Serializable
data class PlayerLegendStatistics(
    val currentSeason: LegendSeasonResult,
    val previousVersusSeason: LegendSeasonResult,
    val bestVersusSeason: LegendSeasonResult,
    val legendTrophies: Int,
    val previousSeason: LegendSeasonResult,
    val bestSeason: LegendSeasonResult
)