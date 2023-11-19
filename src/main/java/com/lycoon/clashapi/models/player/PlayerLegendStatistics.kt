package com.lycoon.clashapi.models.player

import com.lycoon.clashapi.models.league.LegendSeasonResult
import kotlinx.serialization.Serializable

@Serializable
data class PlayerLegendStatistics(
    val previousBuilderBaseSeason: LegendSeasonResult? = null,
    val previousVersusSeason: LegendSeasonResult? = null,
    val bestBuilderBaseSeason: LegendSeasonResult? = null,
    val currentSeason: LegendSeasonResult? = null,
    val legendTrophies: Int = 0,
    val previousSeason: LegendSeasonResult? = null,
    val bestVersusSeason: LegendSeasonResult? = null,
    val bestSeason: LegendSeasonResult? = null
)