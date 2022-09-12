package com.lycoon.clashapi.models.league

import kotlinx.serialization.Serializable

@Serializable
data class LegendSeasonResult(val trophies: Int = 0, val id: String? = null, val rank: Int = 0)